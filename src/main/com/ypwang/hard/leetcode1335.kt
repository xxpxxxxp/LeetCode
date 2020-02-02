package com.ypwang.hard

class Solution1335 {
    fun minDifficulty(jobDifficulty: IntArray, d: Int): Int {
        val dp = Array(d){ IntArray(jobDifficulty.size) { 100000 } }
        var cur = -1
        for ((i, c) in jobDifficulty.withIndex()) {
            cur = maxOf(cur, c)
            dp[0][i] = cur
        }

        for (i in 1 until d) {
            for (j in jobDifficulty.indices) {
                if (i <= j) {
                    var cur = jobDifficulty[j]
                    for (k in j-1 downTo 0) {
                        dp[i][j] = minOf(dp[i][j], dp[i-1][k] + cur)
                        cur = maxOf(cur, jobDifficulty[k])
                    }
                }
            }
        }

        return dp[d-1][jobDifficulty.lastIndex].let { if (it == 100000) -1 else it }
    }
}