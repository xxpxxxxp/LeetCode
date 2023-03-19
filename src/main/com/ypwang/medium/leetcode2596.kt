package com.ypwang.medium

class Solution2596 {
    fun checkValidGrid(grid: Array<IntArray>): Boolean {
        if (grid[0][0] != 0)
            return false

        val mp = grid.withIndex().flatMap { (i, arr) ->
            arr.withIndex().map { (j, v) ->
                intArrayOf(v, i, j)
            }
        }.sortedBy { it[0] }

        for (i in 1 until mp.size) {
            val (_, a, b) = mp[i-1]
            val (_, c, d) = mp[i]
            val dx = Math.abs(a - c)
            val dy = Math.abs(b - d)
            if ((dx == 1 && dy == 2) || (dx == 2 && dy == 1))
                continue
            return false
        }

        return true
    }
}