package com.ypwang.hard

class Solution3130 {
    val MOD = 1000000007

    fun numberOfStableArrays(zero: Int, one: Int, limit: Int): Int {
        val dp = Array(zero + 1) { Array(one + 1) { IntArray(2) } }
        for (i in 1..minOf(zero, limit))
            dp[i][0][0] = 1
        for (i in 1..minOf(one, limit))
            dp[0][i][1] = 1

        for (i in 1..zero) {
            for (j in 1..one) {
                dp[i][j][0] = (dp[i-1][j][0] + dp[i-1][j][1]) % MOD
                if (i > limit)
                    dp[i][j][0] = (dp[i][j][0] + MOD - dp[i-limit-1][j][1]) % MOD

                dp[i][j][1] = (dp[i][j-1][0] + dp[i][j-1][1]) % MOD
                if (j > limit)
                    dp[i][j][1] = (dp[i][j][1] + MOD - dp[i][j-limit-1][0]) % MOD
            }
        }
        return (dp[zero][one][0] + dp[zero][one][1]) % MOD
    }
}
