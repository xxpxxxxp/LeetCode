package com.ypwang.hard

class Solution3367 {
    data class Edge(val to: Int, val weight: Int)

    fun maximizeSumOfWeights(edges: Array<IntArray>, k: Int): Long {
        val n = edges.size + 1
        val tree = Array(n) { mutableListOf<Edge>() }

        for ((u, v, w) in edges) {
            tree[u].add(Edge(v, w))
            tree[v].add(Edge(u, w))
        }

        val dp = Array(n) { LongArray(2) }
        dfs(0, -1, tree, dp, k)

        return dp[0][0]
    }

    private fun dfs(u: Int, parent: Int, tree: Array<MutableList<Edge>>, dp: Array<LongArray>, k: Int) {
        val ds = mutableListOf<Long>()
        var sum0 = 0L

        for ((v, w) in tree[u]) {
            if (v == parent)
                continue

            dfs(v, u, tree, dp, k)

            val delta = w.toLong() + dp[v][1] - dp[v][0]
            ds.add(delta)
            sum0 += dp[v][0]
        }

        ds.sortDescending()

        dp[u][0] = sum0
        for (i in 0 until minOf(k, ds.size)) {
            if (ds[i] > 0) {
                dp[u][0] += ds[i]
            }
        }

        dp[u][1] = sum0
        for (i in 0 until minOf(k - 1, ds.size)) {
            if (ds[i] > 0) {
                dp[u][1] += ds[i]
            }
        }
    }
}
