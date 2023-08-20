package com.ypwang.medium

class Solution2830 {
    fun maximizeTheProfit(n: Int, offers: List<List<Int>>): Int {
        val dp = IntArray(n + 1)
        val m = offers.map { it[1] to it }.groupBy { it.first }.mapValues { it.value.map { kv -> kv.second } }
        for (e in 1..n) {
            dp[e] = dp[e - 1]
            for ((s, _, g) in m.getOrDefault(e - 1, listOf()))
                dp[e] = maxOf(dp[e], dp[s] + g)
        }
        return dp[n]
    }
}
