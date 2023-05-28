package com.ypwang.easy

class Solution2711 {
    fun differenceOfDistinctValues(grid: Array<IntArray>): Array<IntArray> {
        val m = grid.size
        val n = grid[0].size
        val res = Array(m) { IntArray(n) }
        for (i in 0 until m) {
            for (j in 0 until n) {
                val bR = countDistant(grid, i + 1, j + 1, 1)
                val tL = countDistant(grid, i - 1, j - 1, -1)
                res[i][j] = Math.abs(bR - tL)
            }
        }
        return res
    }

    private fun countDistant(grid: Array<IntArray>, i: Int, j: Int, inc: Int): Int {
        var i = i
        var j = j
        val set = mutableSetOf<Int>()
        while (i < grid.size && i >= 0 && j < grid[0].size && j >= 0) {
            set.add(grid[i][j])
            j += inc
            i += inc
        }
        return set.size
    }
}