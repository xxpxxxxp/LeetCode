package com.ypwang.medium

class Solution1219 {
    fun getMaximumGold(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        val path = mutableSetOf<Pair<Int, Int>>()
        fun drie(x: Int, y: Int, before: Int): Int {
            if (x !in 0 until m || y !in 0 until n || x to y in path || grid[x][y] == 0) return before
            path.add(x to y)

            var max = 0
            for ((x1, y1) in listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)) {
                max = maxOf(max, drie(x+x1, y+y1, before+grid[x][y]))
            }
            path.remove(x to y)

            return max
        }

        var max = 0
        for (i in grid.indices) {
            for (j in 0 until n) {
                if (grid[i][j] != 0) max = maxOf(max, drie(i, j, 0))
            }
        }

        return max
    }
}