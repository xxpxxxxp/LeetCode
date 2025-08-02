package com.ypwang.hard

class Solution3600 {
    private fun find(i: Int, ds: IntArray): Int =
        if (ds[i] == i)
            i
        else {
            ds[i] = find(ds[i], ds)
            ds[i]
        }

    fun maxStability(n: Int, edges: Array<IntArray>, k: Int): Int {
        val s_u_v = mutableListOf<Triple<Int, Int, Int>>()
        val ds = IntArray(n) { it }
        var usedEdges = 0
        var res = 200000
        var minSingle = 200000
        var minDouble = 100000

        for (e in edges) {
            if (e[3] == 1) {
                val a = find(e[0], ds)
                val b = find(e[1], ds)
                if (a == b)
                    return -1
                usedEdges++
                ds[b] = a
                res = minOf(res, e[2])
            } else {
                s_u_v.add(Triple(e[2], e[1], e[0]))
            }
        }

        s_u_v.sortByDescending { it.first }

        for ((s, u, v) in s_u_v) {
            val a = find(u, ds)
            val b = find(v, ds)
            if (a != b) {
                ds[b] = a
                usedEdges++
                if (usedEdges == n - 1 - k)
                    minSingle = s
                minDouble = s
            }
        }

        return if (usedEdges == n - 1) {
            minOf(res, minSingle, minDouble * if (k > 0) 2 else 1)
        } else {
            -1
        }
    }
}
