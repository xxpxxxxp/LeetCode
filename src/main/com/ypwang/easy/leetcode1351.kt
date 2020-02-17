package com.ypwang.easy

class Solution1351 {
    fun countNegatives(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        var x = 0
        var y = n - 1
        var rst = 0

        while (x < m) {
            while (y >= 0 && grid[x][y] < 0)
                y--

            rst += (n - 1 - y)
            x++
        }

        return rst
    }
}