package com.ypwang.medium

class Solution4108 {
    fun minCost(n: Int, colors: String, edges: Array<IntArray>): Long {
        val adj = Array(n) { mutableListOf<Int>() }

        for ((a, b) in edges) {
            adj[a].add(b)
            adj[b].add(a)
        }

        val dp = Array(n) { LongArray(3) }
        val sz = IntArray(n) { 1 }

        fun dfs(u: Int, p: Int) {
            var sdp0 = 0L
            var sdp1 = 0L

            for (v in adj[u]) {
                if (v == p)
                    continue

                dfs(v, u)

                sz[u] += sz[v]
                sdp0 += dp[v][0]
                sdp1 += minOf(dp[v][0], dp[v][1])
            }

            val cR = if (colors[u] == 'R') 0L else sz[u].toLong()
            val cB = if (colors[u] == 'B') 0L else sz[u].toLong()

            dp[u][0] = cB + sdp0
            dp[u][1] = cR + sdp1
            dp[u][2] = Long.MAX_VALUE / 4

            for (v in adj[u]) {
                if (v == p)
                    continue

                val bi = minOf(dp[v][1], dp[v][2])
                dp[u][2] = minOf(
                    dp[u][2],
                    cB + sdp0 + bi - dp[v][0]
                )
            }
        }

        dfs(0, -1)
        return minOf(dp[0][0], dp[0][1], dp[0][2])
    }
}
