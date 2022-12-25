package com.ypwang.hard

class Solution2518 {
    fun countPartitions(nums: IntArray, k: Int): Int {
        val mod = 1000000007
        var total = 0L
        var res = 1L
        val dp = LongArray(k)
        dp[0] = 1
        for (a in nums) {
            for (i in k - 1 - a downTo 0)
                dp[i + a] = (dp[i + a] + dp[i]) % mod

            res = res * 2 % mod
            total += a.toLong()
        }

        if (total < 2 * k)
            return 0

        for (i in 0 until k)
            res -= dp[i] * 2

        return ((res % mod + mod) % mod).toInt()
    }
}