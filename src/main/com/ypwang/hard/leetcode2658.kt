package com.ypwang.hard

class Solution2658 {
    fun findMaxFish(grid: Array<IntArray>): Int {
        fun dfs(i: Int, j: Int): Int {
            var t = grid[i][j]
            if (t <= 0)
                return 0

            grid[i][j] = -1
            for ((di, dj) in listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)) {
                val x = i + di
                val y = j + dj
                if (x in grid.indices && y in grid[0].indices)
                    t += dfs(x, y)
            }

            return t
        }

        return grid.withIndex().map { (i, arr) -> arr.withIndex().map { (j, v) -> if (v > 0) dfs(i, j) else 0 }.max()!! }.max()!!
    }
}

fun main() {
    println(Solution2658().findMaxFish(arrayOf(
        intArrayOf(0,2,1,0), intArrayOf(4,0,0,3), intArrayOf(1,0,0,4), intArrayOf(0,3,2,0)
    )))
}