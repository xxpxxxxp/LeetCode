package com.ypwang.hard

class Solution3772 {
    fun maxSubgraphScore(n: Int, edges: Array<IntArray>, good: IntArray): IntArray {
        val adj = Array(n) { mutableListOf<Int>() }

        for ((a, b) in edges) {
            adj[a].add(b)
            adj[b].add(a)
        }

        val v = IntArray(n) { if (good[it] == 1) 1 else -1 }
        val dp = IntArray(n)
        val ans = IntArray(n)

        fun dfsB(u: Int, p: Int) {
            dp[u] = v[u]
            for (v in adj[u]) {
                if (v != p) {
                    dfsB(v, u)
                    if (dp[v] > 0)
                        dp[u] += dp[v]
                }
            }
        }

        fun dfsT(u: Int, p: Int) {
            for (v in adj[u]) {
                if (v != p) {
                    val c = maxOf(0, dp[v])
                    val s = ans[u] - c
                    ans[v] = dp[v] + maxOf(0, s)
                    dfsT(v, u)
                }
            }
        }

        dfsB(0, -1)
        ans[0] = dp[0]
        dfsT(0, -1)

        return ans
    }
}
