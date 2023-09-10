package com.ypwang.hard

class Solution2846 {
    fun minOperationsQueries(n: Int, edges: Array<IntArray>, queries: Array<IntArray>): IntArray {
        val conn = Array(n) { mutableListOf<Pair<Int, Int>>() }
        for ((u, v, w) in edges) {
            conn[u].add(v to w - 1)
            conn[v].add(u to w - 1)
        }

        fun dfs(
            x: Int,
            p: Int,
            b: IntArray,
            e: IntArray,
            f: Array<IntArray>,
            t: IntArray,
            all: Array<IntArray>,
            w: IntArray
        ) {
            all[x] = w.clone()
            f[x][0] = p
            b[x] = ++t[0]
            for (v in conn[x]) {
                if (v.first != p) {
                    w[v.second]++
                    dfs(v.first, x, b, e, f, t, all, w)
                    w[v.second]--
                }
            }
            e[x] = t[0]
        }

        val all = Array(n) { IntArray(26) }
        val f = Array(n) { IntArray(20) }
        val b = IntArray(n)
        val e = IntArray(n)
        val w = IntArray(26)
        val t = intArrayOf(0)
        dfs(0, -1, b, e, f, t, all, w)
        f[0][0] = 0
        for (i in 1..19) {
            for (j in 0 until n) {
                f[j][i] = f[f[j][i - 1]][i - 1]
            }
        }
        val result = IntArray(queries.size)
        var index = 0
        for (q in queries) {
            if (q[0] == q[1]) {
                result[index++] = 0
                continue
            }
            val tLca = lca(f, b, e, q[0], q[1])
            var sum = 0
            var m = 0
            for (i in 0..25) {
                val temp = all[q[0]][i] + all[q[1]][i] - (all[tLca][i] shl 1)
                sum += temp
                m = maxOf(m, temp)
            }
            result[index++] = sum - m
        }
        return result
    }

    fun isAncestor(b: IntArray, e: IntArray, x: Int, y: Int): Boolean =
        b[x] <= b[y] && e[x] >= e[y]

    fun lca(f: Array<IntArray>, b: IntArray, e: IntArray, x: Int, y: Int): Int {
        var x = x
        if (isAncestor(b, e, x, y))
            return x
        if (isAncestor(b, e, y, x))
            return y
        var r = 0
        for (i in 19 downTo 0) {
            val temp = f[x][i]
            if (isAncestor(b, e, temp, y))
                r = temp
            else
                x = temp
        }
        return r
    }
}