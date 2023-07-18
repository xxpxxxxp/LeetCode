package com.ypwang.hard

class Solution2781 {
    fun longestValidSubstring(word: String, forbidden: List<String>): Int {
        val seen = forbidden.toSet()
        val dp = IntArray(word.length+1) { word.length }
        var rst = 0

        for (i in word.length-1 downTo 0) {
            dp[i] = dp[i+1]
            for (j in i until minOf(dp[i], word.length, i+10)) {
                if (word.substring(i, j+1) in seen) {
                    dp[i] = j
                    break
                }
            }
            rst = maxOf(rst, dp[i] - i)
        }

        return rst
    }
}