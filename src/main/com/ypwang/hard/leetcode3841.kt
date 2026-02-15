package com.ypwang.hard

import java.util.*

class Solution3841 {
    val LOG = 17

    fun palindromePath(n: Int, edges: Array<IntArray>, s: String, queries: Array<String>): List<Boolean> {
        val graph = Array(n) { mutableListOf<Int>() }
        for ((a, b) in edges) {
            graph[a].add(b)
            graph[b].add(a)
        }

        val parent = Array(LOG) { IntArray(n) { -1 } }

        val depth = IntArray(n)
        val tin = IntArray(n)
        val tout = IntArray(n)
        val timer = intArrayOf(0)

        // ---------- DFS ----------
        dfs(0, -1, graph, parent, depth, tin, tout, timer)

        // ---------- Binary lifting ----------
        for (k in 1 until LOG) {
            for (i in 0 until n) {
                val p = parent[k - 1][i]
                if (p != -1)
                    parent[k][i] = parent[k - 1][p]
            }
        }

        // ---------- Fenwick tree ----------
        val fenwick = Fenwick(n)

        val labels = s.toCharArray()
        for (i in 0 until n) {
            val m = mask(labels[i])
            fenwick.add(tin[i], m)
            fenwick.add(tout[i] + 1, m)
        }

        val ans = mutableListOf<Boolean>()

        for (q in queries) {
            val p = q.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

            if (p[0] == "update") {
                val u = p[1].toInt()
                val c = p[2][0]

                val delta = mask(labels[u]) xor mask(c)
                labels[u] = c

                fenwick.add(tin[u], delta)
                fenwick.add(tout[u] + 1, delta)
            } else {
                val u = p[1].toInt()
                val v = p[2].toInt()
                val w = lca(u, v, parent, depth)

                val m = (fenwick.sum(tin[u])
                        xor fenwick.sum(tin[v])
                        xor mask(labels[w]))

                ans.add(m == 0 || (m and (m - 1)) == 0)
            }
        }

        return ans
    }

    // ---------- DFS helper ----------
    private fun dfs(
        u: Int, p: Int,
        g: Array<MutableList<Int>>,
        parent: Array<IntArray>,
        depth: IntArray,
        tin: IntArray,
        tout: IntArray,
        timer: IntArray
    ) {
        tin[u] = timer[0]++
        parent[0][u] = p

        for (v in g[u]) {
            if (v == p)
                continue
            depth[v] = depth[u] + 1
            dfs(v, u, g, parent, depth, tin, tout, timer)
        }

        tout[u] = timer[0] - 1
    }

    // ---------- LCA ----------
    private fun lca(u: Int, v: Int, parent: Array<IntArray>, depth: IntArray): Int {
        var u = u
        var v = v
        if (depth[u] < depth[v]) {
            val t = u
            u = v
            v = t
        }

        val d = depth[u] - depth[v]
        for (k in 0 until LOG)
            if ((d and (1 shl k)) != 0)
                u = parent[k][u]

        if (u == v) return u

        for (k in LOG - 1 downTo 0) {
            if (parent[k][u] != parent[k][v]) {
                u = parent[k][u]
                v = parent[k][v]
            }
        }

        return parent[0][u]
    }

    private fun mask(c: Char): Int =
        1 shl (c - 'a')

    // ---------- Fenwick Tree ----------
    class Fenwick(var n: Int) {
        var bit = IntArray(n + 1)

        fun add(i: Int, `val`: Int) {
            var i = i
            i++
            while (i <= n) {
                bit[i] = bit[i] xor `val`
                i += i and -i
            }
        }

        fun sum(i: Int): Int {
            var i = i
            var r = 0
            i++
            while (i > 0) {
                r = r xor bit[i]
                i -= i and -i
            }
            return r
        }
    }
}
