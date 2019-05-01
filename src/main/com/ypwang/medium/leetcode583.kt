package com.ypwang.medium

class Solution583 {
    fun minDistance(word1: String, word2: String): Int {
        val dp = IntArray((word1.length + 1) * (word2.length + 1))

        for (i in 0..word1.length)
            dp[i * (word2.length + 1)] = i

        for (j in 0..word2.length)
            dp[j] = j

        for (i in 1..word1.length) {
            for (j in 1..word2.length) {
                dp[i * (word2.length + 1) + j] =
                if (word1[i-1] == word2[j-1]) dp[(i - 1) * (word2.length + 1) + j - 1]
                else 1 + minOf(dp[(i - 1) * (word2.length + 1) + j], dp[i * (word2.length + 1) + j - 1])
            }
        }

        return dp.last()
    }
}