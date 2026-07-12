package com.ypwang.hard

class Solution3989 {
    fun maxConsistentColumns(grid: Array<IntArray>, limit: Int): Int {
        val m = grid.size
        val n = grid[0].size

        val dp = IntArray(n)
        var ans = 1

        for (j in 0 until n) {
            dp[j] = 1

            for (i in 0 until j) {
                var ok = true

                for (r in 0 until m) {
                    if (Math.abs(grid[r][j] - grid[r][i]) > limit) {
                        ok = false
                        break
                    }
                }

                if (ok)
                    dp[j] = maxOf(dp[j], dp[i] + 1)
            }

            ans = maxOf(ans, dp[j])
        }

        return ans
    }
}
