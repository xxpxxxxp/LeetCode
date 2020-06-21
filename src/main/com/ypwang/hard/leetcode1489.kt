package com.ypwang.hard

class Solution1489 {
    class UnionFind(n: Int) {
        private val rank = Array(n){1}
        private val parent = Array(n){ it }

        fun parent(x: Int): Int {
            if (parent[x] != x) {
                parent[x] = parent(parent[x])
            }

            return parent[x]
        }

        fun union(x: Int, y: Int) {
            var px = parent(x)
            var py = parent(y)
            if (px == py) return
            if (rank[px] > rank[py]) {
                val t = py
                py = px
                px = t
            }

            parent[px] = py
            if (rank[px] == rank[py]) rank[py]++
        }
    }

    fun findCriticalAndPseudoCriticalEdges(n: Int, edges: Array<IntArray>): List<List<Int>> {
        val sortedEdges = edges.withIndex().sortedBy { it.value[2] }

        fun getMST(blockEdge: Int, pre: Int): Int {
            val ufs = UnionFind(n)
            var weight = 0
            if (pre != -1) {
                weight += sortedEdges[pre].value[2]
                ufs.union(sortedEdges[pre].value[0], sortedEdges[pre].value[1])
            }

            for (i in sortedEdges.indices) {
                if (i == blockEdge) continue
                val edge = sortedEdges[i].value
                if (ufs.parent(edge[0]) == ufs.parent(edge[1])) continue
                ufs.union(edge[0], edge[1])
                weight += edge[2]
            }

            for (i in 0 until n) {
                if (ufs.parent(i) != ufs.parent(0)) return 1000000007
            }

            return weight
        }

        val origin = getMST(-1, -1)
        val critical = mutableListOf<Int>()
        val nonCritical = mutableListOf<Int>()
        for (i in sortedEdges.indices) {
            if (origin < getMST(i, -1))
                critical.add(sortedEdges[i].index)
            else if (origin == getMST(-1, i))
                nonCritical.add(sortedEdges[i].index)
        }

        return listOf(critical, nonCritical)
    }
}

fun main() {
    println(Solution1489().findCriticalAndPseudoCriticalEdges(14, arrayOf(
            intArrayOf(0,1,13),intArrayOf(0,2,6),intArrayOf(2,3,13),intArrayOf(3,4,4),intArrayOf(0,5,11),intArrayOf(4,6,14),intArrayOf(4,7,8),intArrayOf(2,8,6),intArrayOf(4,9,6),intArrayOf(7,10,4),intArrayOf(5,11,3),intArrayOf(6,12,7),intArrayOf(12,13,9),intArrayOf(7,13,2),intArrayOf(5,13,10),intArrayOf(0,6,4),intArrayOf(2,7,3),intArrayOf(0,7,8),intArrayOf(1,12,9),intArrayOf(10,12,11),intArrayOf(1,2,7),intArrayOf(1,3,10),intArrayOf(3,10,6),intArrayOf(6,10,4),intArrayOf(4,8,5),intArrayOf(1,13,4),intArrayOf(11,13,8),intArrayOf(2,12,10),intArrayOf(5,8,1),intArrayOf(3,7,6),intArrayOf(7,12,12),intArrayOf(1,7,9),intArrayOf(5,9,1),intArrayOf(2,13,10),intArrayOf(10,11,4),intArrayOf(3,5,10),intArrayOf(6,11,14),intArrayOf(5,12,3),intArrayOf(0,8,13),intArrayOf(8,9,1),intArrayOf(3,6,8),intArrayOf(0,3,4),intArrayOf(2,9,6),intArrayOf(0,11,4),intArrayOf(2,5,14),intArrayOf(4,11,2),intArrayOf(7,11,11),intArrayOf(1,11,6),intArrayOf(2,10,12),intArrayOf(0,13,4),intArrayOf(3,9,9),intArrayOf(4,12,3),intArrayOf(6,7,10),intArrayOf(6,8,13),intArrayOf(9,11,3),intArrayOf(1,6,2),intArrayOf(2,4,12),intArrayOf(0,10,3),intArrayOf(3,12,1),intArrayOf(3,8,12),intArrayOf(1,8,6),intArrayOf(8,13,2),intArrayOf(10,13,12),intArrayOf(9,13,11),intArrayOf(2,11,14),intArrayOf(5,10,9),intArrayOf(5,6,10),intArrayOf(2,6,9),intArrayOf(4,10,7),intArrayOf(3,13,10),intArrayOf(4,13,3),intArrayOf(3,11,9),intArrayOf(7,9,14),intArrayOf(6,9,5),intArrayOf(1,5,12),intArrayOf(4,5,3),intArrayOf(11,12,3),intArrayOf(0,4,8),intArrayOf(5,7,8),intArrayOf(9,12,13),intArrayOf(8,12,12),intArrayOf(1,10,6),intArrayOf(1,9,9),intArrayOf(7,8,9),intArrayOf(9,10,13),intArrayOf(8,11,3),intArrayOf(6,13,7),intArrayOf(0,12,10),intArrayOf(1,4,8),intArrayOf(8,10,2)
    )))
}