package com.ypwang.hard

class Solution3812 {
    fun minimumFlips(n: Int, edges: Array<IntArray>, start: String, target: String): List<Int> {
        val g = Array(n) { mutableListOf<Pair<Int, Int>>() }
        for (i in edges.indices) {
            val (u, v) = edges[i]
            g[u].add(Pair(v, i))
            g[v].add(Pair(u, i))
        }

        val s = start.map { it - '0' }.toIntArray()
        val t = target.map { it - '0' }.toIntArray()
        val solution = mutableListOf<Int>()

        fun dfs(u: Int, p: Int, edge: Int) {
            for ((v, e) in g[u]) {
                if (v == p)
                    continue
                dfs(v, u, e)
            }
            if (s[u] != t[u] && edge != -1) {
                solution.add(edge)
                s[u] = s[u] xor 1
                s[p] = s[p] xor 1
            }
        }

        dfs(0, 0, -1)

        return if (s[0] != t[0]) listOf(-1) else solution.sorted()
    }
}
