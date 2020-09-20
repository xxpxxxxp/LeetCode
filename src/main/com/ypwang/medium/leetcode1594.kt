package com.ypwang.medium

class Solution1594 {
    fun maxProductPath(grid: Array<IntArray>): Int {
        if (grid[0][0] == 0) return 0

        val m = grid.size
        val n = grid[0].size

        val dp = Array(m){ Array(n){ LongArray(2) } }
        dp[0][0][0] = grid[0][0].toLong()
        dp[0][0][1] = grid[0][0].toLong()
        for (i in 1 until m) {
            dp[i][0][0] = grid[i][0] * dp[i-1][0][0]
            dp[i][0][1] = grid[i][0] * dp[i-1][0][1]
        }

        for (j in 1 until n) {
            dp[0][j][0] = grid[0][j] * dp[0][j-1][0]
            dp[0][j][1] = grid[0][j] * dp[0][j-1][1]
        }

        for (i in 1 until m) {
            for (j in 1 until n) {
                val v = grid[i][j]
                if (v < 0) {
                    dp[i][j][0] = maxOf(dp[i-1][j][1], dp[i][j-1][1]) * v
                    dp[i][j][1] = minOf(dp[i-1][j][0], dp[i][j-1][0]) * v
                } else {
                    dp[i][j][0] = minOf(dp[i-1][j][0], dp[i][j-1][0]) * v
                    dp[i][j][1] = maxOf(dp[i-1][j][1], dp[i][j-1][1]) * v
                }
            }
        }

        return dp[m-1][n-1][1].let { if (it >= 0) (it % 1000000007).toInt() else -1 }
    }
}