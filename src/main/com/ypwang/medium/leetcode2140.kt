package com.ypwang.medium

class Solution2140 {
    fun mostPoints(questions: Array<IntArray>): Long {
        val dp = LongArray(200001)
        for ((i, p) in questions.withIndex().reversed())
            dp[i] = maxOf(dp[i+1], p[0] + dp[i + p[1] + 1])

        return dp[0]
    }
}