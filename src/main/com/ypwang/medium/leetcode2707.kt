package com.ypwang.medium

class Solution2707 {
    fun minExtraChar(s: String, dictionary: Array<String>): Int {
        val words = dictionary.toSet()

        val dp = IntArray(s.length + 1)
        for (i in 1..s.length) {
            dp[i] = dp[i - 1] + 1
            for (j in i - 1 downTo 0) {
                val substring = s.substring(j, i)
                if (substring in words) {
                    dp[i] = minOf(dp[i], dp[j])
                }
            }
        }
        return dp.last()
    }
}