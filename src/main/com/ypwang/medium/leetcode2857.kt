package com.ypwang.medium

class Solution2857 {
    fun countPairs(coordinates: List<List<Int>>, k: Int): Int {
        val count = mutableMapOf<Int, MutableMap<Int, Int>>()
        var rst = 0
        for ((x1, y1) in coordinates) {
            for (x in 0..k) {
                val x2 = x1 xor x
                val y2 = y1 xor k - x
                if (x2 in count && y2 in count[x2]!!)
                    rst += count[x2]!![y2]!!
            }
            val t = count.getOrPut(x1, { mutableMapOf() })
            t[y1] = t.getOrDefault(y1, 0) + 1
        }

        return rst
    }
}