package com.ypwang.medium

class Solution3531 {
    fun countCoveredBuildings(n: Int, buildings: Array<IntArray>): Int {
        val yRangeGivenX = mutableMapOf<Int, IntArray>()
        val xRangeGivenY = mutableMapOf<Int, IntArray>()

        for ((x, y) in buildings) {
            yRangeGivenX.putIfAbsent(x, intArrayOf(Int.Companion.MAX_VALUE, Int.Companion.MIN_VALUE))
            yRangeGivenX.get(x)!![0] = minOf(yRangeGivenX[x]!![0], y)
            yRangeGivenX.get(x)!![1] = maxOf(yRangeGivenX[x]!![1], y)

            xRangeGivenY.putIfAbsent(y, intArrayOf(Int.Companion.MAX_VALUE, Int.Companion.MIN_VALUE))
            xRangeGivenY.get(y)!![0] = minOf(xRangeGivenY[y]!![0], x)
            xRangeGivenY.get(y)!![1] = maxOf(xRangeGivenY[y]!![1], x)
        }

        return buildings.count { (x, y) -> xRangeGivenY[y]!![0] < x && x < xRangeGivenY[y]!![1] && yRangeGivenX[x]!![0] < y && y < yRangeGivenX[x]!![1] }
    }
}
