package com.ypwang.medium

class Solution3070 {
    fun countSubmatrices(grid: Array<IntArray>, k: Int): Int {
        var rst = 0
        val m = grid.size
        val n = grid[0].size
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (i > 0)
                    grid[i][j] += grid[i-1][j]
                if (j > 0)
                    grid[i][j] += grid[i][j-1]
                if (i > 0 && j > 0)
                    grid[i][j] -= grid[i-1][j-1]
                if (grid[i][j] <= k)
                    rst++
            }
        }

        return rst
    }
}
