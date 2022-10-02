package com.ypwang.medium

class Solution2428 {
    private var dir = arrayOf(intArrayOf(0, 0), intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 1), intArrayOf(2, 0), intArrayOf(2, 1), intArrayOf(2, 2))

    fun maxSum(grid: Array<IntArray>): Int {
        var max = 0
        for (i in grid.indices) {
            for (j in 0 until grid[0].size) {
                val sum = hourGlass(grid, i, j)
                max = maxOf(max, sum)
            }
        }
        return max
    }

    private fun hourGlass(grid: Array<IntArray>, i: Int, j: Int): Int {
        if (i + 2 >= grid.size || j + 2 >= grid[0].size)
            return 0

        return dir.map { (x, y) -> grid[i + x][j + y] }.sum()
    }
}