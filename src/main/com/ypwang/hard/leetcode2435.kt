package com.ypwang.hard

class Solution2435 {
    fun numberOfPaths(grid: Array<IntArray>, k: Int): Int {
        val dp = Array(50001) { IntArray(51) }
        val m = grid.size
        val n = grid[0].size

        fun dfs(i: Int, j: Int, mod: Int): Int {
            if (i >= m || j >= n)
                return 0

            if (i == m - 1 && j == n - 1)
                return if (((mod + grid[i][j]) % k) == 0) 1 else 0

            if (dp[i * n + j][mod] == 0)
                dp[i * n + j][mod] = (1 + dfs(i + 1, j, (mod + grid[i][j]) % k) + dfs(i, j + 1, (mod + grid[i][j]) % k)) % 1000000007

            return dp[i * n + j][mod] - 1;
        }

        return dfs(0, 0, 0)
    }
}