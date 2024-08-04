package com.ypwang.medium

class Solution3243 {
    fun shortestDistanceAfterQueries(n: Int, queries: Array<IntArray>): IntArray {
        val roads = Array(n) { mutableListOf<Int>() }
        val dp = IntArray(n) { it }
        val rst = IntArray(queries.size)

        for ((j, query) in queries.withIndex()) {
            roads[query[1]].add(query[0])

            for (i in query[1] until n) {
                dp[i] = minOf(dp[i], dp[i - 1] + 1)
                for (l in roads[i])
                    dp[i] = minOf(dp[i], dp[l] + 1)
            }

            rst[j] = dp[n - 1]
        }

        return rst
    }
}
