package com.ypwang.medium

class Solution3665 {
    fun uniquePaths(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size
        val dp = Array(n) { Array(m) { IntArray(2) { -1 } } }
        return f(0, 0, 0, grid, n, m, dp)
    }

    fun f(i: Int, j: Int, dir: Int, grid: Array<IntArray>, n: Int, m: Int, dp: Array<Array<IntArray>>): Int {
        if (i == n - 1 && j == m - 1)
            return 1
        if (i >= n || j >= m)
            return 0

        if (dp[i][j][dir] == -1) {
            var ways = 0L
            if (grid[i][j] == 1) {
                ways += if (dir == 0)
                    f(i + 1, j, 1, grid, n, m, dp)
                else
                    f(i, j + 1, 0, grid, n, m, dp)
            } else {
                ways += f(i + 1, j, 1, grid, n, m, dp)
                ways += f(i, j + 1, 0, grid, n, m, dp)
            }
            dp[i][j][dir] = ways.toInt() % 1000000007
        }

        return dp[i][j][dir]
    }
}
