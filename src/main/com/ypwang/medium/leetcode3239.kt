package com.ypwang.medium

class Solution3239 {
    fun minFlips(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        var row = 0
        var col = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] != grid[m-1-i][j])
                    col++
                if (grid[i][j] != grid[i][n-1-j])
                    row++
            }
        }

        return minOf(row, col) / 2
    }
}
