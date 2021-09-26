package com.ypwang.medium

class Solution2017 {
    fun gridGame(grid: Array<IntArray>): Long {
        var topSum = grid[0].map { it.toLong() }.sum()
        var bottomSum = 0L
        var ans = Long.MAX_VALUE
        for (i in grid[0].indices) {
            topSum -= grid[0][i]
            ans = minOf(ans, maxOf(topSum, bottomSum))
            bottomSum += grid[1][i]
        }
        return ans
    }
}