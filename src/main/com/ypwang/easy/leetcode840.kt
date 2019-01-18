package com.ypwang.easy

class Solution840 {
    fun numMagicSquaresInside(grid: Array<IntArray>): Int {
        val x = grid.size
        val y = grid[0].size
        val rst = mutableListOf<Pair<Int, Int>>()
        for (i in 1 until x-1) {
            for (j in 1 until y-1) {
                if (grid[i][j] == 5) {
                    rst.add(Pair(i, j))
                }
            }
        }

        return rst.count {
            val m = it.first
            val n = it.second
            val surround = intArrayOf(grid[m-1][n-1], grid[m-1][n], grid[m-1][n+1],
                    grid[m][n+1], grid[m+1][n+1], grid[m+1][n], grid[m+1][n-1], grid[m][n-1])
            val sstr = surround.joinToString("")
            surround[0] % 2 == 0 && ("4381672943816729".contains(sstr) || "4927618349276183".contains(sstr))
        }
    }
}