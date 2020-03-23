package com.ypwang.medium

class Solution1391 {
    fun hasValidPath(grid: Array<IntArray>): Boolean {
        val m = grid.size
        val n = grid[0].size

        /*       1
                ---
             0 |   | 2
                ---
                 3
         */
        val dsu = IntArray(m * n * 4){ it }

        fun parent(idx: Int): Int {
            if (dsu[idx] != idx) dsu[idx] = parent(dsu[idx])
            return dsu[idx]
        }

        fun union(ix: Int, iy: Int) {
            dsu[parent(ix)] = parent(iy)
        }

        val mapping = arrayOf(
                intArrayOf(0, 2),
                intArrayOf(1, 3),
                intArrayOf(0, 3),
                intArrayOf(2, 3),
                intArrayOf(0, 1),
                intArrayOf(1, 2)
        )

        for (i in 0 until m) {
            for (j in 0 until n) {
                val idx = (i * n + j) * 4
                if (i > 0)
                    union(((i - 1) * n + j) * 4 + 3,idx + 1)

                if (j > 0)
                    union((i * n + j - 1) * 4 + 2, idx)

                val (x, y) = mapping[grid[i][j] - 1]
                union(idx + x, idx + y)
            }
        }

        return parent(mapping[grid[0][0] - 1][0]) == parent((m * n - 1) * 4 + mapping[grid[m-1][n-1] - 1][0])
    }
}

fun main() {
    println(Solution1391().hasValidPath(arrayOf(intArrayOf(2,4,3), intArrayOf(6,5,2))))
    println(Solution1391().hasValidPath(arrayOf(intArrayOf(1,2,1), intArrayOf(1,2,1))))
    println(Solution1391().hasValidPath(arrayOf(intArrayOf(1,1,2))))
    println(Solution1391().hasValidPath(arrayOf(intArrayOf(1,1,1,1,1,1,3))))
    println(Solution1391().hasValidPath(arrayOf(intArrayOf(2), intArrayOf(2), intArrayOf(2), intArrayOf(2), intArrayOf(2), intArrayOf(2), intArrayOf(6))))
    println(Solution1391().hasValidPath(arrayOf(intArrayOf(4,1), intArrayOf(6,1))))
    println(Solution1391().hasValidPath(arrayOf(intArrayOf(6,1,3), intArrayOf(4,1,5))))
}