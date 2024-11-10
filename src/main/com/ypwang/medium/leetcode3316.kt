package com.ypwang.medium

class Solution3316 {
    fun maxRemovals(source: String, pattern: String, targetIndices: IntArray): Int {
        val n = source.length
        val m = pattern.length
        val target = IntArray(n)
        val dp = IntArray(m + 1) { Int.MIN_VALUE }
        for (i in targetIndices)
            target[i] += 1
        dp[m] = 0
        for (i in n - 1 downTo 0) {
            for (j in 0..m) {
                dp[j] += target[i]
                if (j < m && source[i] == pattern[j])
                    dp[j] = maxOf(dp[j], dp[j + 1])
            }
        }
        return dp[0]
    }
}
