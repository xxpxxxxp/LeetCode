package com.ypwang.hard

class Solution1579 {
    fun maxNumEdgesToRemove(n: Int, edges: Array<IntArray>): Int {
        var root = IntArray(n){ it }

        fun parent(i: Int): Int {
            if (i != root[i]) root[i] = parent(root[i])
            return root[i]
        }

        fun union(i: Int, j: Int): Boolean {
            val ri = parent(i)
            val rj = parent(j)
            if (ri == rj) return false

            root[ri] = rj
            return true
        }

        var rst = 0
        var c1 = 0
        var c2 = 0

        for ((type, i, j) in edges) {
            if (type == 3) {
                if (union(i-1, j-1)) {
                    c1++
                    c2++
                } else
                    rst++
            }
        }

        val cp = root.clone()
        for ((type, i, j) in edges) {
            if (type == 1) {
                if (union(i-1, j-1))
                    c1++
                else
                    rst++
            }
        }

        root = cp
        for ((type, i, j) in edges) {
            if (type == 2) {
                if (union(i-1, j-1))
                    c2++
                else
                    rst++
            }
        }

        return if (c1 == n-1 && c2 == n-1) rst else -1
    }
}