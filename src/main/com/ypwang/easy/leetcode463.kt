package com.ypwang.easy

class Solution463 {
    fun islandPerimeter(grid: Array<IntArray>): Int {
        var cube = 0
        var connect = 0
        for (i in 0..grid.size) {
            for (j in 0..grid[0].size) {
                if (grid[i][j] == 1) {
                    cube++

                    if (i+1 < grid.size && grid[i+1][j] == 1) {
                        connect++
                    }
                    if (j+1 < grid[0].size && grid[i][j+1] == 1) {
                        connect++
                    }
                }
            }
        }
        return 4*cube-2*connect
    }
}