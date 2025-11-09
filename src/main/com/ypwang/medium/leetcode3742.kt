package com.ypwang.medium

class Solution3742 {
    fun maxPathScore(grid: Array<IntArray>, k: Int): Int {
        val m = grid.size
        val n = grid[0].size
        val dp = Array(m) { Array(n) { IntArray(k + 1) { Int.MIN_VALUE } } }

        val result = maxPathScore(0, 0, m, n, 0, k, grid, dp)
        return if (result < 0) -1 else result
    }

    private fun maxPathScore(
        r: Int,
        c: Int,
        m: Int,
        n: Int,
        currK: Int,
        k: Int,
        grid: Array<IntArray>,
        dp: Array<Array<IntArray>>
    ): Int {
        if (r >= m || c >= n || currK > k)
            return -100000

        if (r == m - 1 && c == n - 1) {
            return if (currK + getCost(grid[r][c]) <= k)
                grid[r][c]
            else -100000
        }

        val newK = currK + getCost(grid[r][c])
        if (newK > k)
            return -100000

        if (dp[r][c][newK] != Int.MIN_VALUE)
            return dp[r][c][newK]

        val takeRight = grid[r][c] + maxPathScore(r, c + 1, m, n, newK, k, grid, dp)
        val takeDown = grid[r][c] + maxPathScore(r + 1, c, m, n, newK, k, grid, dp)

        val result = maxOf(takeRight, takeDown)
        return result.also { dp[r][c][newK] = it }
    }

    private fun getCost(v: Int): Int = if (v == 0) 0 else 1
}
