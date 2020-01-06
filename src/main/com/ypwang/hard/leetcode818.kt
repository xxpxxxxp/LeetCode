package com.ypwang.hard

class Solution818 {
    fun racecar(target: Int): Int {
        val dp = IntArray(target + 1)

        for (i in 1..target) {
            dp[i] = Int.MAX_VALUE
            var m = 1
            var j = 1
            while (j < i) {
                var q = 0
                var p = 0
                while (p < j) {
                    dp[i] = Math.min(dp[i], m + 1 + q + 1 + dp[i - (j - p)])
                    p = (1 shl ++q) - 1
                }
                j = (1 shl ++m) - 1
            }
            dp[i] = Math.min(dp[i], m + if (i == j) 0 else 1 + dp[j - i])
        }

        return dp[target]
    }
}