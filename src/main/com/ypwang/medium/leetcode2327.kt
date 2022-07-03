package com.ypwang.medium

class Solution2327 {
    fun peopleAwareOfSecret(n: Int, delay: Int, forget: Int): Int {
        val dp = LongArray(n + 1)
        val mod = 1000000007
        var share = 0L
        var res = 0L
        dp[1] = 1
        for (i in 2..n) {
            share = (share + dp[maxOf(i - delay, 0)] - dp[maxOf(i - forget, 0)] + mod) % mod
            dp[i] = share
        }
        for (i in n - forget + 1..n)
            res = (res + dp[i]) % mod

        return res.toInt()
    }
}