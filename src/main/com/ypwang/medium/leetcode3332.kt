package com.ypwang.medium

class Solution3332 {
    fun maxScore(n: Int, k: Int, stayScore: Array<IntArray>, travelScore: Array<IntArray>): Int {
        val dp = Array(k + 1) { IntArray(n) }

        for (day in 0 until k) {
            for (cur in 0 until n) {
                dp[day + 1][cur] = maxOf(dp[day + 1][cur], dp[day][cur] + stayScore[day][cur])
                for (des in 0 until n) {
                    if (des != cur)
                        dp[day + 1][des] = maxOf(dp[day + 1][des], dp[day][cur] + travelScore[cur][des])
                }
            }
        }

        return dp[k].max()!!
    }
}
