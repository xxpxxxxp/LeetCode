package com.ypwang.medium

class Solution1143 {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val dp = IntArray((text1.length + 1) * (text2.length + 1))

        for (i in 0 until text1.length) {
            for (j in 0 until text2.length) {
                dp[(i+1)*(text2.length+1)+j+1] =
                    if (text1[i] == text2[j]) dp[i*(text2.length+1)+j] + 1
                    else maxOf(dp[(i+1)*(text2.length+1)+j], dp[i*(text2.length+1)+j+1])
            }
        }

        return dp.last()
    }
}