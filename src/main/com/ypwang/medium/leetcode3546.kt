package com.ypwang.medium

class Solution3546 {
    fun canPartitionGrid(grid: Array<IntArray>): Boolean {
        val n = grid.size
        val m = grid[0].size
        val rowSum = grid.sumOf { it.sum() }

        var colSum = 0
        for (i in 0..<n - 1) {
            for (j in 0..<m)
                colSum += grid[i][j]
            if (colSum * 2 == rowSum)
                return true
        }

        colSum = 0
        for (j in 0..<m - 1) {
            for (i in 0..<n)
                colSum += grid[i][j]
            if (colSum * 2 == rowSum)
                return true
        }

        return false
    }
}
