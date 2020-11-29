package com.ypwang.medium

class Solution959 {
    class DSU(N: Int) {
        private val parent: IntArray = IntArray(N) { it }

        fun find(x: Int): Int {
            if (parent[x] != x) parent[x] = find(parent[x])
            return parent[x]
        }

        fun union(x: Int, y: Int) {
            parent[find(x)] = find(y)
        }
    }

    fun regionsBySlashes(grid: Array<String>): Int {
        val len = grid.size
        val flat = 4 * len * len
        val dsu = DSU(flat)
        for (r in 0 until len)
            for (c in 0 until len) {
                val root = 4 * (r * len + c)

                // north south
                if (r + 1 < len)
                    dsu.union(root + 3, root + 4 * len + 0)
                if (r - 1 >= 0)
                    dsu.union(root + 0, root - 4 * len + 3)
                // east west
                if (c + 1 < len)
                    dsu.union(root + 2, root + 4 + 1)
                if (c - 1 >= 0)
                    dsu.union(root + 1, root - 4 + 2)

                val `val` = grid[r][c]
                if (`val` != '\\') {
                    dsu.union(root + 0, root + 1)
                    dsu.union(root + 2, root + 3)
                }
                if (`val` != '/') {
                    dsu.union(root + 0, root + 2)
                    dsu.union(root + 1, root + 3)
                }
            }

        return (0 until flat).count { dsu.find(it) == it }
    }
}

fun main() {
    println(Solution959().regionsBySlashes(arrayOf(
            " /",
            "/ "
    )))
}