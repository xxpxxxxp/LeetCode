package com.ypwang.medium

class Solution3195 {
    fun minimumArea(grid: Array<IntArray>): Int {
        var minX = Int.MAX_VALUE
        var minY = Int.MAX_VALUE
        var maxX = Int.MIN_VALUE
        var maxY = Int.MIN_VALUE

        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 1) {
                    minX = minOf(minX, i)
                    minY = minOf(minY, j)
                    maxX = maxOf(maxX, i)
                    maxY = maxOf(maxY, j)
                }
            }
        }

        return (maxX - minX + 1) * (maxY - minY + 1)
    }
}
