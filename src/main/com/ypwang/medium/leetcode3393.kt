package com.ypwang.medium

class Solution3393 {
    private val mod = 1000000007

    fun countPathsWithXorValue(grid: Array<IntArray>, k: Int): Int {
        val n = grid.size
        val m = grid[0].size

        val dp = Array(n) { Array(m) { IntArray(20) { -1 } } }

        fun f(i: Int, j: Int, curr: Int): Int {
            if (i >= n || j >= m)
                return 0

            val newCurr = curr xor grid[i][j]

            if (i == n - 1 && j == m - 1)
                return if (newCurr == k) 1 else 0

            if (dp[i][j][newCurr] != -1)
                return dp[i][j][newCurr]

            val right = f(i, j + 1, newCurr) % mod
            val down = f(i + 1, j, newCurr) % mod

            dp[i][j][newCurr] = (right + down) % mod
            return dp[i][j][newCurr]
        }

        return f(0, 0, 0)
    }
}
