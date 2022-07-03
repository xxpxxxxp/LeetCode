package com.ypwang.hard

class Solution2328 {
    fun countPaths(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        val dp = Array(1000) { IntArray(1000) { -1 } }
        val mod = 1000000007
        fun dfs(i: Int, j: Int, v: Int): Int {
            if (minOf(i, j) < 0 || i >= m || j >= n || grid[i][j] <= v)
                return 0

            if (dp[i][j] == -1)
                dp[i][j] = ((1L + dfs(i + 1, j, grid[i][j]) + dfs(i - 1, j, grid[i][j])
                        + dfs(i, j + 1, grid[i][j]) + dfs(i, j - 1, grid[i][j])) % mod).toInt()

            return dp[i][j]
        }

        var rst = 0
        for (i in 0 until m)
            for (j in 0 until n)
                rst = (rst + dfs(i, j, 0)) % mod

        return rst
    }
}