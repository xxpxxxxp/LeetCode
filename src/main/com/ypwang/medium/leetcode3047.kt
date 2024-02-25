package com.ypwang.medium

class Solution3047 {
    fun largestSquareArea(bottomLeft: Array<IntArray>, topRight: Array<IntArray>): Long {
        var rst = 0
        val n = bottomLeft.size
        for (i in 0 until n) {
            val firstRectBL = bottomLeft[i]
            val firstRectTR = topRight[i]
            for (j in i + 1 until n) {
                val secondRectBL = bottomLeft[j]
                val secondRectTR = topRight[j]
                if (secondRectBL[0] >= firstRectTR[0] || secondRectBL[1] >= firstRectTR[1] ||
                    secondRectTR[0] <= firstRectBL[0] || secondRectTR[1] <= firstRectBL[1])
                    continue
                val pntAx = maxOf(firstRectBL[0], secondRectBL[0])
                val pntAy = maxOf(firstRectBL[1], secondRectBL[1])
                val pntBx = minOf(firstRectTR[0], secondRectTR[0])
                val pntBy = minOf(firstRectTR[1], secondRectTR[1])
                val sideA = pntBx - pntAx
                val sideB = pntBy - pntAy
                rst = maxOf(rst, minOf(sideA, sideB))
            }
        }
        return rst.toLong() * rst
    }
}
