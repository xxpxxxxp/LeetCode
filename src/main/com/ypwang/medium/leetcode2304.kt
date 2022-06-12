package com.ypwang.medium

class Solution2304 {
    fun minPathCost(grid: Array<IntArray>, moveCost: Array<IntArray>): Int {
        var dp = grid[0]
        for (i in 1 until grid.size) {
            val clone = dp.clone()
            for (j in grid[0].indices) {
                var min = Int.MAX_VALUE
                for (k in grid[0].indices)
                    min = minOf(min, dp[k] + moveCost[grid[i - 1][k]][j] + grid[i][j])
                clone[j] = min
            }
            dp = clone
        }
        return dp.minOrNull()!!
    }
}