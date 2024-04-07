package com.ypwang.hard

class Solution3108 {
    class DSU(n: Int) {
        private val parent: IntArray = IntArray(n) { it }
        private val rank: IntArray = IntArray(n)
        private val weights: IntArray = IntArray(n) { 0x1FFFF }

        fun find(x: Int): Int {
            if (x != parent[x])
                parent[x] = find(parent[x])
            return parent[x]
        }

        fun union(x: Int, y: Int, weight: Int) {
            val xx = find(x)
            val yy = find(y)
            if (rank[xx] < rank[yy])
                parent[xx] = yy
            else
                parent[yy] = xx
            weights[yy] = weights[xx] and weights[yy] and weight
            weights[xx] = weights[yy]
            if (rank[xx] == rank[yy])
                rank[xx]++
        }

        fun minimumCostOfWalk(x: Int, y: Int): Int {
            if (x == y)
                return 0
            if (find(x) != find(y))
                return -1
            return weights[find(x)]
        }
    }

    fun minimumCost(n: Int, edges: Array<IntArray>, query: Array<IntArray>): IntArray {
        val uf = DSU(n)
        for ((a, b, w) in edges)
            uf.union(a, b, w)
        return IntArray(query.size) { uf.minimumCostOfWalk(query[it][0], query[it][1]) }
    }
}
