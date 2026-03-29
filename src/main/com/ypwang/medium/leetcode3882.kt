package com.ypwang.medium

class Solution3882 {
    fun minCost(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size

        val dp = Array(n) { Array(m) { IntArray(1024) { -1 } } }

        fun dfs(i: Int, j: Int, xori: Int): Int {
            var xori = xori
            if (i >= n || j >= m)
                return Int.MAX_VALUE

            xori = xori xor grid[i][j]

            if (i == n - 1 && j == m - 1)
                return xori

            if (dp[i][j][xori] != -1)
                return dp[i][j][xori]

            val right = dfs(i, j + 1, xori)
            val down = dfs(i + 1, j, xori)

            return minOf(right, down).also { dp[i][j][xori] = it }
        }

        return dfs(0, 0, 0)
    }
}
