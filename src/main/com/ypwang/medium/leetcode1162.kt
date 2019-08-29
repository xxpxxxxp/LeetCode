package com.ypwang.medium

class Solution1162 {
    fun maxDistance(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        for (i in 0 until m) {
            for (j in 0 until n) {
                grid[i][j] = (300 shl 4) or grid[i][j]
            }
        }

        val dim = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
        fun spread(i: Int, j: Int, dis: Int) {
            for (d in dim) {
                val x = i + d.first
                val y = j + d.second
                if (x in 0 until m && y in 0 until n && grid[x][y] and 0x1 == 0 && (grid[x][y] shr 4) > dis) {
                    grid[x][y] = (dis shl 4)
                    spread(x, y, dis+1)
                }
            }
        }

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] and 0x1 == 1) {
                    spread(i, j, 1)
                }
            }
        }

        var max = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] and 0x1 == 0) {
                    max = maxOf(max, grid[i][j] shr 4)
                }
            }
        }

        return if (max == 0 || max == 300) -1 else max
    }
}

fun main() {
    println(Solution1162().maxDistance(arrayOf(intArrayOf(1,0,0), intArrayOf(0,0,0), intArrayOf(0,0,0))))
}