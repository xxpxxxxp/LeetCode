package com.ypwang.easy

class Solution4052 {
    fun cyclicShift(n: Int, grid: Array<IntArray>, rowShift: IntArray, colShift: IntArray): Array<IntArray> {
        val rows = Array(2 * n) { IntArray(n) }
        val cols = Array(n) { IntArray(2 * n) }

        //for cols
        for (i in 0 until n) {
            for (j in 0 until n) {
                cols[i][j] = grid[i][j]
                cols[i][n + j] = grid[i][j]
            }
        }

        for (i in 0 until n)
            for (j in 0 until n)
                grid[i][j] = cols[i][j + rowShift[i]]

        //for rows
        for (i in 0 until n) {
            for (j in 0 until n) {
                rows[i][j] = grid[i][j]
                rows[n + i][j] = grid[i][j]
            }
        }

        for (i in 0 until n)
            for (j in 0 until n)
                grid[i][j] = rows[i + colShift[j]][j]

        return grid
    }
}
