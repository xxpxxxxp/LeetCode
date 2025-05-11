package com.ypwang.medium

class Solution3543 {
    fun maxWeight(n: Int, edges: Array<IntArray>, k: Int, t: Int): Int {
        val adj = Array(n) { mutableListOf<IntArray>() }
        for ((a, b, c) in edges) adj[a].add(intArrayOf(b, c))

        val dp = Array(n) { Array(k+1) { mutableSetOf<Int>() } }
        for (i in 0..<n)
            dp[i][0].add(0)

        for (e in 0 until k) {
            for (u in 0 until n) {
                for ((v, wt) in adj[u]) {
                    for (w in dp[u][e]) {
                        val newW = w + wt
                        if (newW < t)
                            dp[v][e+1].add(newW)
                    }
                }
            }
        }

        var ans = -1
        for (u in 0..<n)
            if (dp[u][k].isNotEmpty())
                ans = maxOf(ans, dp[u][k].max())

        return ans
    }
}
