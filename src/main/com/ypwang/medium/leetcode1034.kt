package com.ypwang.medium

class Solution1034 {
    fun colorBorder(grid: Array<IntArray>, r0: Int, c0: Int, color: Int): Array<IntArray> {
        if (grid[r0][c0] == color) return grid

        val c = grid[r0][c0]
        val set = setOf(c, Int.MAX_VALUE, Int.MIN_VALUE)
        fun helper(y: Int, x: Int) {
            // Int.MAX_VALUE: visited, keep origin
            // Int.MIN_VALUE: visited and colored
            if (grid[y][x] != c) return

            grid[y][x] = Int.MAX_VALUE
            if (y == 0 || y == grid.lastIndex || x == 0 || x == grid[0].lastIndex) grid[y][x] = Int.MIN_VALUE
            val neighbor = mutableListOf<Pair<Int, Int>>()
            if (y > 0 && grid[y-1][x] in set) neighbor.add(y-1 to x)
            if (y < grid.lastIndex && grid[y+1][x] in set) neighbor.add(y+1 to x)
            if (x > 0 && grid[y][x-1] in set) neighbor.add(y to x-1)
            if (x < grid[0].lastIndex && grid[y][x+1] in set) neighbor.add(y to x+1)

            if (neighbor.size != 4) grid[y][x] = Int.MIN_VALUE
            neighbor.forEach{ helper(it.first, it.second) }
        }

        helper(r0, c0)

        for (i in 0 until grid.size) {
            for (j in 0 until grid[0].size) {
                if (grid[i][j] == Int.MAX_VALUE) grid[i][j] = c
                else if (grid[i][j] == Int.MIN_VALUE) grid[i][j] = color
            }
        }

        return grid
    }
}

fun main() {
    println(Solution1034().colorBorder(arrayOf(intArrayOf(2,1,3,2,1,1,2),intArrayOf(1,2,3,1,2,1,2),intArrayOf(1,2,1,2,2,2,2),intArrayOf(2,1,2,2,2,2,2),intArrayOf(2,3,3,3,2,1,2)), 4, 4, 3).map { it.toList() })
}