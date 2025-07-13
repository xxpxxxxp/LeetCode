package com.ypwang.medium

class Solution3613 {
    class UnionFind(n: Int) {
        val parent = IntArray(n) { it }

        fun find(x: Int): Int {
            if (parent[x] != x)
                parent[x] = find(parent[x])
            return parent[x]
        }

        fun union(x: Int, y: Int): Boolean {
            val px = find(x)
            val py = find(y)
            if (px == py)
                return false
            parent[py] = px
            return true
        }
    }

    fun minCost(n: Int, edges: Array<IntArray>, k: Int): Int {
        edges.sortBy { it[2] }

        val uf = UnionFind(n)
        val mstEdges = mutableListOf<Int>()

        for ((u, v, w) in edges)
            if (uf.union(u, v))
                mstEdges.add(w)

        mstEdges.sortDescending()

        var i = 0
        while (i < k - 1 && mstEdges.isNotEmpty()) {
            mstEdges.removeAt(0)
            i++
        }

        return if (mstEdges.isEmpty()) 0 else mstEdges.first()
    }
}
