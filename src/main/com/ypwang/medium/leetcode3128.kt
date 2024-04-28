package com.ypwang.medium

class Solution3128 {
    fun numberOfRightTriangles(grid: Array<IntArray>): Long {
        val row = IntArray(grid.size)
        val col = IntArray(grid[0].size)

        for (i in grid.indices)
            for (j in grid[0].indices)
                if (grid[i][j] == 1) {
                    row[i]++
                    col[j]++
                }

        var rst = 0L
        for (i in grid.indices)
            for (j in grid[0].indices)
                if (grid[i][j] == 1)
                    rst += (row[i] - 1) * (col[j] - 1)

        return rst
    }
}

fun main() {
    println(Solution3128().numberOfRightTriangles(arrayOf(
        intArrayOf(0,1,0), intArrayOf(0,1,1), intArrayOf(0,1,0)
    )))
}