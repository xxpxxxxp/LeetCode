package com.ypwang.medium

class Solution10033 {
    fun minimumOperationsToMakeEqual(x: Int, y: Int): Int {
        val dp = IntArray(10011) { -1 }

        fun solve(x: Int, y: Int): Int {
            if (x <= y)
                return y - x
            if (dp[x] != -1)
                return dp[x]
            var res = Math.abs(x - y)
            res = minOf(res, 1 + x % 5 + solve(x / 5, y))
            res = minOf(res, 1 + (5 - x % 5) + solve(x / 5 + 1, y))
            res = minOf(res, 1 + x % 11 + solve(x / 11, y))
            res = minOf(res, 1 + (11 - x % 11) + solve(x / 11 + 1, y))
            return res.also { dp[x] = it }
        }

        return solve(x, y)
    }
}