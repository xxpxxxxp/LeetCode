package com.ypwang.easy

class Solution3643 {
    fun reverseSubmatrix(grid: Array<IntArray>, x: Int, y: Int, k: Int): Array<IntArray> {
        for (j in y until y + k) {
            for (i in 0 until k / 2) {
                val t = grid[x + i][j]
                grid[x + i][j] = grid[x + k - 1 - i][j]
                grid[x + k - 1 - i][j] = t
            }
        }

        return grid
    }
}
