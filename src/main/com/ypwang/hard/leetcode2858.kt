package com.ypwang.hard

class Solution2858 {
    fun minEdgeReversals(n: Int, edges: Array<IntArray>): IntArray {
        val conn = Array(n) { mutableMapOf<Int, Int>() }
        val dp = Array(n+1) { mutableMapOf<Int, Int>() }

        for ((a, b) in edges) {
            conn[a][b] = 0
            conn[b][a] = 1
            dp[a][b] = -1
            dp[b][a] = -1
            dp[n][a] = -1
            dp[n][b] = -1
        }

        fun dfs(i: Int, j: Int): Int {
            if (dp[i].getOrDefault(j, -1) < 0) {
                dp[i][j] = 0
                for ((next, d) in conn[j]) {
                    if (next == i)
                        continue
                    dp[i][j] = dp[i][j]!! + dfs(j, next) + d
                }
            }

            return dp[i][j]!!
        }

        return (0 until n).map { dfs(n, it) }.toIntArray()
    }
}