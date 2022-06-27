package com.ypwang.easy

class Solution2319 {
    fun checkXMatrix(grid: Array<IntArray>): Boolean {
        val size = grid.size
        return grid.withIndex().all { (i, arr) ->
            arr.withIndex().all { (j, v) ->
                if (i == j || i == size-1-j)
                    v != 0
                else
                    v == 0
            }
        }
    }
}