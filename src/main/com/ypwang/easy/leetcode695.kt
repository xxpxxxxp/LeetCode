package com.ypwang.easy

class Solution695 {
    fun search(x: Int, y: Int, grid: Array<IntArray>): Int {
        if (grid[x][y] == 0 || grid[x][y] == 2) {
            return 0
        }

        grid[x][y] = 2
        var area = 1

        if (x-1 >= 0) {
            area += search(x-1, y, grid)
        }
        if (x+1 < grid.size) {
            area += search(x+1, y, grid)
        }
        if (y-1 >= 0) {
            area += search(x, y-1, grid)
        }
        if (y+1 < grid[0].size) {
            area += search(x, y+1, grid)
        }

        return area
    }

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        if (grid.isEmpty()) {
            return 0
        }

        var area = 0
        for (i in 0 until grid.size) {
            for (j in 0 until grid[0].size) {
                when (grid[i][j]) {
                    1 -> area = kotlin.math.max(area, search(i, j, grid))
                    else -> {}
                }
            }
        }

        return area
    }
}

fun main() {
    println(Solution695().maxAreaOfIsland(arrayOf(intArrayOf(1,1,0,0,0), intArrayOf(1,1,0,0,0), intArrayOf(0,0,0,1,1), intArrayOf(0,0,0,1,1))))
}