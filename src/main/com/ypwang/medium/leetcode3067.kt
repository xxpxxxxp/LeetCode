package com.ypwang.medium

class Solution3067 {
    fun countPairsOfConnectableServers(edges: Array<IntArray>, signalSpeed: Int): IntArray {
        val n = edges.size
        val adj = Array(n + 1) { mutableListOf<IntArray>() }

        for ((a, b, w) in edges) {
            adj[a].add(intArrayOf(b, w))
            adj[b].add(intArrayOf(a, w))
        }

        fun dfs(parent: Int, n: Int, weight: Int): Int {
            var ans = 0
            if (weight % signalSpeed == 0)
                ans++
            for ((next, w) in adj[n]) {
                if (next != parent)
                    ans += dfs(n, next, weight + w)
            }
            return ans
        }

        fun cal(n: Int): Int {
            var prev = 0
            var ans = 0
            for ((next, w) in adj[n]) {
                val k = dfs(n, next, w)
                ans += prev * k
                prev += k
            }
            return ans
        }

        return IntArray(n+1) { cal(it) }
    }
}
