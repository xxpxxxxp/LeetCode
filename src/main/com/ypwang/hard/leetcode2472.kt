package com.ypwang.hard

class Solution2472 {
    fun maxPalindromes(s: String, k: Int): Int {
        if (k == 1)
            return s.length

        val dp = IntArray(s.length + 1)
        val pal = Array(s.length + 1) { BooleanArray(s.length + 1) }

        for (len in 1 .. k+1) {
            for (i in 0 .. s.length-len) {
                val j = i+len-1
                pal[i][j] = s[i] == s[j] && if (len < 3) true else pal[i+1][j-1]
            }
        }

        for (i in k - 1 until s.length) {
            dp[i + 1] = dp[i]
            if (pal[i - k + 1][i])
                dp[i + 1] = maxOf(dp[i + 1], 1 + dp[i - k + 1])
            if (i - k >= 0 && pal[i - k][i])
                dp[i + 1] = maxOf(dp[i + 1], 1 + dp[i - k])
        }
        return dp.last()
    }
}