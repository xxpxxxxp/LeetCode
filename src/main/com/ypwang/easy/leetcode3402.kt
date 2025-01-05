package com.ypwang.easy

class Solution3402 {
    fun minimumOperations(grid: Array<IntArray>): Int {
        val m = grid[0].size
        val n = grid.size

        var rst = 0
        for (i in 0 until m) {
            var init = grid[0][i]
            for (j in 1 until n) {
                rst += maxOf(0, init + 1 - grid[j][i])
                init = maxOf(init+1, grid[j][i])
            }
        }

        return rst
    }
}
