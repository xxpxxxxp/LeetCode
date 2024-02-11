package com.ypwang.hard

class Solution3027 {
    fun numberOfPairs(points: Array<IntArray>): Int {
        points.sortWith(compareBy<IntArray> { it[0] }.thenByDescending { it[1] })
        var rst =  0
        for (i in points.indices) {
            val y1 = points[i][1]
            var y = Int.MIN_VALUE
            for (j in i+1 until points.size) {
                val y2 = points[j][1]
                if (y2 in y+1..y1) {
                    rst++
                    y = y2
                }
            }
        }

        return rst
    }
}