package com.ypwang.medium

class Solution2482 {
    fun onesMinusZeros(grid: Array<IntArray>): Array<IntArray> {
        val row = grid.map { 2 * it.sum() - it.size }.toIntArray()
        val col = grid[0].indices.map { i -> grid.map { it[i] } }.map { 2 * it.sum() - it.size }.toIntArray()

        for (i in grid.indices) {
            for (j in grid[0].indices)
                grid[i][j] = row[i] + col[j]
        }

        return grid
    }
}