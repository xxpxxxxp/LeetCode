package com.ypwang.easy

class Solution3142 {
    fun satisfiesConditions(grid: Array<IntArray>): Boolean {
        val m = grid.size
        val n = grid[0].size

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (i < m-1 && grid[i][j] != grid[i+1][j])
                    return false
                if (j < n-1 && grid[i][j] == grid[i][j+1])
                    return false
            }
        }

        return true
    }
}
