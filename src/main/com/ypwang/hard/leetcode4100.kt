package com.ypwang.hard

class Solution4100 {
    private val INF = Long.MAX_VALUE / 4
    private lateinit var graph: Array<MutableList<IntArray>>
    private lateinit var a: IntArray
    private var ans = INF

    fun minActivationCost(edges: Array<IntArray>, A: IntArray): Long {
        val n = A.size
        a = A

        graph = Array(n) { mutableListOf<IntArray>() }

        for (e in edges) {
            val (u, v, w) = e
            graph[u].add(intArrayOf(v, w))
            graph[v].add(intArrayOf(u, w))
        }

        ans = INF
        dfs(0, -1)

        return if (ans < INF) ans else -1L
    }

    private fun dfs(i: Int, parent: Int): LongArray {
        val b = Integer.bitCount(a[i]) and 1

        val f = longArrayOf(INF, INF)
        f[b] = 0L

        for (e in graph[i]) {
            val j = e[0]
            val c = e[1].toLong()

            if (j == parent) continue

            val g = dfs(j, i)

            ans = minOf(
                ans,
                f[0] + g[0] + c,
                f[1] + g[1] + c
            )

            f[b] = minOf(f[b], g[0] + c)
            f[b xor 1] = minOf(f[b xor 1], g[1] + c)
        }

        return f
    }
}
