package com.ypwang.easy

class Solution994 {
    fun orangesRotting(grid: Array<IntArray>): Int {
        for (i in 0 until grid.size) {
            for (j in 0 until grid[0].size) {
                if (grid[i][j] == 1)
                    grid[i][j] = 1025
            }
        }

        fun set(i: Int, j: Int, v: Int) {
            if (grid[i][j] and 0x1 > 0) {
                if (v < grid[i][j] shr 2) {
                    grid[i][j] = (v shl 2) + 1

                    if (i > 0) set(i-1, j, v+1)
                    if (i < grid.size-1) set(i+1, j, v+1)
                    if (j > 0) set(i, j-1, v+1)
                    if (j < grid[0].size-1) set(i, j+1, v+1)
                }
            }
        }

        for (i in 0 until grid.size) {
            for (j in 0 until grid[0].size) {
                if (grid[i][j] == 2) {
                    if (i > 0) set(i-1, j, 1)
                    if (i < grid.size-1) set(i+1, j, 1)
                    if (j > 0) set(i, j-1, 1)
                    if (j < grid[0].size-1) set(i, j+1, 1)
                }
            }
        }

        var max = 0
        for (i in 0 until grid.size) {
            for (j in 0 until grid[0].size) {
                if (grid[i][j] == 1025)
                    return -1
                if (grid[i][j] and 0x1 > 0) {
                    val v = grid[i][j] shr 2
                    if (v > max) max = v
                }
            }
        }

        return max
    }
}

fun main() {
    println(Solution994().orangesRotting(arrayOf(
            intArrayOf(2,1,1,1,1,1,1,1,1,1),intArrayOf(0,0,0,0,0,0,0,0,0,1),intArrayOf(1,1,1,1,1,1,1,1,0,1),intArrayOf(1,0,0,0,0,0,0,1,0,1),intArrayOf(1,0,1,1,1,1,0,1,0,1),intArrayOf(1,0,1,0,0,1,0,1,0,1),intArrayOf(1,0,1,0,0,0,0,1,0,1),intArrayOf(1,0,1,1,1,1,1,1,0,1),intArrayOf(1,0,0,0,0,0,0,0,0,1),intArrayOf(1,1,1,1,1,1,1,1,1,1)
    )))
}