package com.ypwang.hard

class Solution3563 {
    fun lexicographicallySmallestString(s: String): String {
        val n = s.length
        val dp = Array(n+1) { Array(n+1) { "" } }
        for (len in 1 .. n) {
            for (i in 0 .. n - len) {
                val j = i + len
                var res = s[i] + dp[i+1][j]
                for (k in i+1 until j) {
                    val diff = Math.abs(s[i] - s[k])
                    if ((diff == 1 || diff == 25) && dp[i+1][k].isEmpty())
                        res = minOf(res, dp[k+1][j])
                }

                dp[i][j] = res
            }
        }

        return dp[0][n]
    }
}
