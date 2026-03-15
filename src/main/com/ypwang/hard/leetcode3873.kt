package com.ypwang.hard

class Solution3873 {
    fun maxActivated(points: Array<IntArray>): Int {
        val n = points.size
        val parent = IntArray(n) { it }
        val size = IntArray(n) { 1 }

        fun find(i: Int): Int {
            if (parent[i] == i) return i
            // Path Compression
            return find(parent[i]).also { parent[i] = it }
        }

        fun union(i: Int, j: Int) {
            val rootI = find(i)
            val rootJ = find(j)
            if (rootI != rootJ) {
                // Union by Size
                if (size[rootI] < size[rootJ]) {
                    parent[rootI] = rootJ
                    size[rootJ] += size[rootI]
                } else {
                    parent[rootJ] = rootI
                    size[rootI] += size[rootJ]
                }
            }
        }

        val xmap = HashMap<Int, Int>()
        val ymap = HashMap<Int, Int>()

        for ((i, arr) in points.withIndex()) {
            val (x, y) = arr

            if (x in xmap)
                union(i, xmap[x]!!)
            else
                xmap[x] = i

            if (y in ymap)
                union(i, ymap[y]!!)
            else
                ymap[y] = i
        }

        return 1 + parent.asSequence().withIndex()
            .filter { it.index == it.value }
            .map { size[it.value] }
            .sortedDescending()
            .take(2)
            .sum()
    }
}
