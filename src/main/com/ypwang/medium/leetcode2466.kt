package com.ypwang.medium

class Solution2466 {
    fun countGoodStrings(low: Int, high: Int, zero: Int, one: Int): Int {
        val dp = IntArray(high + 1)
        dp[0] = 1
        val mod = 1000000007
        var rst = 0
        for (i in 1..high) {
            if (i >= zero)
                dp[i] = (dp[i] + dp[i - zero]) % mod
            if (i >= one)
                dp[i] = (dp[i] + dp[i - one]) % mod
            if (i >= low)
                rst = (rst + dp[i]) % mod
        }
        return rst
    }
}