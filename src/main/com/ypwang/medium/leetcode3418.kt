package com.ypwang.medium

class Solution3418 {
    private fun solve(coins: Array<IntArray>, r: Int, c: Int, i: Int, j: Int, skip: Int, dp: Array<Array<IntArray>>): Int {
        if (i == r - 1 && j == c - 1)
            return if (coins[i][j] < 0 && skip > 0) 0 else coins[i][j]

        if (dp[i][j][skip] != Int.MIN_VALUE)
            return dp[i][j][skip]

        var val1 = Int.MIN_VALUE
        var val2 = Int.MIN_VALUE
        if (i < r - 1) {
            val1 = if (coins[i][j] < 0 && skip > 0)
                maxOf(solve(coins, r, c, i + 1, j, skip - 1, dp), coins[i][j] + solve(coins, r, c, i + 1, j, skip, dp))
            else
                coins[i][j] + solve(coins, r, c, i + 1, j, skip, dp)
        }
        if (j < c - 1) {
            val2 = if (coins[i][j] < 0 && skip > 0)
                maxOf(solve(coins, r, c, i, j + 1, skip - 1, dp), coins[i][j] + solve(coins, r, c, i, j + 1, skip, dp))
            else
                coins[i][j] + solve(coins, r, c, i, j + 1, skip, dp)
        }

        dp[i][j][skip] = maxOf(val1, val2)
        return dp[i][j][skip]
    }

    fun maximumAmount(coins: Array<IntArray>): Int {
        val r = coins.size
        val c = coins[0].size
        val dp = Array(r) { Array(c) { IntArray(3) { Int.MIN_VALUE } } }
        return solve(coins, r, c, 0, 0, 2, dp)
    }
}
