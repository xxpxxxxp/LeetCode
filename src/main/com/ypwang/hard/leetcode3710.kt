package com.ypwang.hard

class Solution3710 {
    class DSU(n: Int) {
        private val rank = IntArray(n + 1) { 0 }
        private val parent = IntArray(n + 1) { it }

        fun findUpar(node: Int): Int {
            if (node == parent[node])
                return node
            parent[node] = findUpar(parent[node])
            return parent[node]
        }

        fun unionByRank(u: Int, v: Int) {
            val ulpU = findUpar(u)
            val ulpV = findUpar(v)
            if (ulpU == ulpV) return

            when {
                rank[ulpU] < rank[ulpV] -> parent[ulpU] = ulpV
                rank[ulpV] < rank[ulpU] -> parent[ulpV] = ulpU
                else -> {
                    parent[ulpV] = ulpU
                    rank[ulpU]++
                }
            }
        }
    }

    private fun manhattan(a: IntArray, b: IntArray): Int =
        Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1])

    private fun valid(points: Array<IntArray>, value: Int): Boolean {
        val n = points.size
        val dsu = DSU(2 * n)

        for (i in 0 until n) {
            for (j in i + 1 until n) {
                if (manhattan(points[i], points[j]) < value) {
                    dsu.unionByRank(i, j + n)
                    dsu.unionByRank(i + n, j)
                }
            }
        }

        return (0 until n).all { dsu.findUpar(it) != dsu.findUpar(it + n) }
    }

    fun maxPartitionFactor(points: Array<IntArray>): Int {
        val n = points.size
        if (n == 2)
            return 0

        var high = 0
        for (i in 0 until n)
            for (j in i + 1 until n)
                high = maxOf(high, manhattan(points[i], points[j]))

        var low = 0
        while (low < high) {
            val mid = (low + high + 1) / 2
            if (valid(points, mid))
                low = mid
            else
                high = mid - 1
        }

        return low
    }
}
