package com.ypwang.hard

class Solution2742 {
    fun paintWalls(cost: IntArray, time: IntArray): Int {
        val n = cost.size
        val dp = IntArray(n + 1) { 1000000000 }
        dp[0] = 0
        for (i in 0 until n)
            for (j in n downTo 1)
                dp[j] = minOf(dp[j], dp[maxOf((j - time[i] - 1), 0)] + cost[i])
        return dp[n]
    }
}