package com.ypwang.medium

class Solution2352 {
    fun equalPairs(grid: Array<IntArray>): Int {
        var rst = 0
        val n= grid.size
        for (i in 0 until n) {
            var j = 0
            for (j in 0 until n) {
                var k = 0
                while (k < n) {
                    if (grid[i][k] != grid[k][j])
                        break
                    k++
                }
                if (k == n)
                    rst++
            }
        }
        return rst
    }
}