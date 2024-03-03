package com.ypwang.medium

class Solution3071 {
    fun minimumOperationsToWriteY(grid: Array<IntArray>): Int {
        val n = grid.size
        val h = n / 2
        val y = mutableListOf<Int>()
        val ny = mutableListOf<Int>()
        for (i in 0 until n) {
            for (j in 0 until n) {
                if ((i == j && i in 0 until h) ||
                    (i == n-1-j && i in 0 until h) ||
                    (j == h && i in h until n))
                    y.add(grid[i][j])
                else
                    ny.add(grid[i][j])
            }
        }

        var rst = Int.MAX_VALUE
        for (i in 0..2) {
            for (j in 0..2) {
                if (i == j)
                    continue

                // convert y to i, and ny to j
                rst = minOf(rst, y.count { it != i } + ny.count { it != j })
            }
        }

        return rst
    }
}
