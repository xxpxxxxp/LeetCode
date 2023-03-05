package com.ypwang.hard

class Solution2585 {
    private final val mod = 1000000007
    fun waysToReachTarget(target: Int, types: Array<IntArray>): Int {
        val dp = IntArray(target + 1)
        dp[0] = 1
        for (t in types)
            for (i in target downTo 1) {
                var k = 1
                while (k <= t[0] && i - t[1] * k >= 0) {
                    dp[i] = (dp[i] + dp[i - t[1] * k]) % mod
                    ++k
                }
            }
        return dp[target]
    }
}