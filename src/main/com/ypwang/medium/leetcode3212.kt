package com.ypwang.medium

class Solution3212 {
    fun numberOfSubmatrices(grid: Array<CharArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val cache = Array(m) { Array(n) { IntArray(2) } }

        var rst = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                var x = 0
                var y = 0

                if (i > 0) {
                    val (a, b) = cache[i-1][j]
                    x += a
                    y += b
                }

                if (j > 0) {
                    val (a, b) = cache[i][j-1]
                    x += a
                    y += b
                }

                if (i > 0 && j > 0) {
                    val (a, b) = cache[i-1][j-1]
                    x -= a
                    y -= b
                }

                when (grid[i][j]) {
                    'X' -> x++
                    'Y' -> y++
                }

                if (x > 0 && x == y)
                    rst++

                cache[i][j][0] = x
                cache[i][j][1] = y
            }
        }

        return rst
    }
}
