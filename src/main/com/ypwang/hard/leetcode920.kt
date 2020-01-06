package com.ypwang.hard

class Solution920 {
    fun numMusicPlaylists(N: Int, L: Int, K: Int): Int {
        val mod = 1000000007

        val dp = Array(L + 1) { LongArray(N + 1) }
        dp[0][0] = 1
        for (i in 1..L) {
            for (j in 1..N) {
                dp[i][j] =
                        (dp[i][j] +
                         dp[i - 1][j - 1] * (N - j + 1) +
                         dp[i - 1][j] * maxOf(j - K, 0)) % mod
            }
        }

        return dp[L][N].toInt()
    }
}