package com.ypwang.medium

class Solution3608 {
    fun minTime(n: Int, edges: Array<IntArray>, k: Int): Int {
        if (edges.isEmpty())
            return 0

        edges.sortByDescending { it[2] }
        val parent = IntArray(n) { it }

        fun find(i: Int): Int =
            if (parent[i] == i)
                i
            else {
                parent[i] = find(parent[i])
                parent[i]
            }

        fun union(i: Int, j: Int): Boolean {
            var i = i
            var j = j
            i = find(i)
            j = find(j)
            if (i != j) {
                parent[i] = j
                return true
            }
            return false
        }

        var count = n
        for ((u, v, t) in edges) {
            if (union(u, v))
                count--

            if (count < k)
                return t
        }

        return 0
    }
}
