package com.ypwang.hard

class Solution3887 {
    fun numberOfEdgesAdded(n: Int, edges: Array<IntArray>): Int {
        val parent = IntArray(n) { it }
        val size = IntArray(n) { 1 }
        val parity = IntArray(n) { 0 }

        fun find(x: Int): Pair<Int, Int> {
            if (parent[x] == x)
                return Pair(x, 0)

            val (root, par) = find(parent[x])
            parent[x] = root
            parity[x] = parity[x] xor par

            return Pair(parent[x], parity[x])
        }

        fun unite(u: Int, v: Int, w: Int): Boolean {
            var (pu, xu) = find(u)
            var (pv, xv) = find(v)

            if (pu == pv)
                // check if adding edge keeps parity consistent
                return (xu xor xv) == w

            // union by size
            if (size[pu] < size[pv]) {
                val tempP = pu
                pu = pv
                pv = tempP

                val tempX = xu
                xu = xv
                xv = tempX
            }

            parent[pv] = pu
            // set parity
            parity[pv] = xu xor xv xor w
            size[pu] += size[pv]

            return true
        }

        var count = 0

        for ((u, v, w) in edges)
            if (unite(u, v, w))
                count++

        return count
    }
}
