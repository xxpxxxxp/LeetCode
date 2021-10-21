package com.ypwang.hard

class Solution847 {
    fun shortestPathLength(graph: Array<IntArray>): Int {
        val dp = Array(1 shl graph.size){ IntArray(graph.size){ 10000 } }
        for (i in graph.indices) dp[1 shl i][i] = 0

        for (i in 1 until dp.size) {
            var repeat: Boolean
            do {
                repeat = false
                for (j in graph.indices) {
                    for (c in graph[j]) {
                        val n = i or (1 shl c)
                        if (dp[i][j] + 1 < dp[n][c]) {
                            dp[n][c] = dp[i][j] + 1
                            if (i == n) repeat = true
                        }
                    }
                }
            } while (repeat)
        }

        return dp.last().minOrNull()!!
    }
}

fun main() {
    println(Solution847().shortestPathLength(arrayOf(intArrayOf(1,2,3), intArrayOf(0), intArrayOf(0), intArrayOf(0))))
    println(Solution847().shortestPathLength(arrayOf(intArrayOf(1), intArrayOf(0,2,4), intArrayOf(1,2,3), intArrayOf(2), intArrayOf(1,2))))
}