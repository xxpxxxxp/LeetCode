package com.ypwang.medium

class Solution2370 {
    fun longestIdealString(s: String, k: Int): Int {
        var rst = 0
        val dp = IntArray(26)
        for (c in s) {
            val i = c - 'a'
            for (j in maxOf(0, i - k) .. minOf(25, i + k))
                dp[i] = maxOf(dp[i], dp[j])
            dp[i]++
            rst = maxOf(rst, dp[i])
        }
        return rst
    }
}