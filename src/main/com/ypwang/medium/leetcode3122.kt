package com.ypwang.medium

class Solution3122 {
    fun minimumOperations(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        val cnt = Array(1000) { IntArray(10) { 0 } }


        for (i in 0 until m)
            for (j in 0 until n)
                cnt[j][grid[i][j]]++

        val dp = Array(1000) { IntArray(10) { 0 } }

        fun dfs(i: Int, p: Int): Int {
            if (i == n)
                return 0
            if (dp[i][p] == 0)
                for (v in 0 until 10)
                    if (i == 0 || v != p)
                        dp[i][p] = maxOf(dp[i][p], cnt[i][v] + dfs(i + 1, v))

            return dp[i][p]
        }

        return m * n - dfs(0, 0)
    }
}
