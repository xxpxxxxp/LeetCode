package com.ypwang.easy

class Solution2373 {
    fun largestLocal(grid: Array<IntArray>): Array<IntArray> {
        val n = grid.size
        val rst = Array(n-2) { IntArray(n-2) }
        for (i in 0 until n-2)
            for (j in 0 until n-2)
                for (ii in i until i+3)
                    for (jj in j until j+3)
                        rst[i][j] = maxOf(rst[i][j], grid[ii][jj])
        return rst
    }
}