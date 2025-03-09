package com.ypwang.medium

class Solution3472 {
    fun longestPalindromicSubsequence(s: String, k: Int): Int {
        val n = s.length
        val dp = Array(n) { Array(n) { IntArray(k + 1) } }
        for (i in 0 until n)
            for (it in 0..k)
                dp[i][i][it] = 1

        for (length in 2..n) {
            for (i in 0..n - length) {
                val j = i + length - 1
                for (it in 0..k) {
                    if (s[i] == s[j]) {
                        dp[i][j][it] = 2 + dp[i + 1][j - 1][it]
                    } else {
                        val c = minOf(Math.abs(s[i] - s[j]), 26 - Math.abs(s[i] - s[j]))
                        dp[i][j][it] = maxOf(dp[i + 1][j][it], dp[i][j - 1][it], if (it >= c) 2 + dp[i + 1][j - 1][it - c] else 0)
                    }
                }
            }
        }
        return dp[0][n - 1][k]
    }
}
