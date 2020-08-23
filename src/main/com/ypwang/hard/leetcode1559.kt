package com.ypwang.hard

class Solution1559 {
    fun containsCycle(grid: Array<CharArray>): Boolean {
        val m = grid.size
        val n = grid[0].size

        fun bfs(i: Int, j: Int, c: Char, fromx: Int, fromy: Int): Boolean {
            if (grid[i][j].isUpperCase())
                return grid[i][j] + 32 == c

            if (grid[i][j] != c)
                return false

            grid[i][j] = grid[i][j] - 32
            return listOf(-1 to 0, 1 to 0, 0 to 1, 0 to -1).any { (dx, dy) ->
                val x = i + dx
                val y = j + dy

                (x != fromx || y != fromy) && x in 0 until m && y in 0 until n && bfs(x, y, c, i, j)
            }
        }

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j].isLowerCase() && bfs(i, j, grid[i][j], -1, -1))
                    return true
            }
        }

        return false
    }
}

fun main() {
    println(Solution1559().containsCycle(listOf(
            "aaaa", "abba", "abba", "aaaa"
    ).map { it.toCharArray() }.toTypedArray()))
    println(Solution1559().containsCycle(listOf(
            "ccca", "cdcc", "ccec", "fccc"
    ).map { it.toCharArray() }.toTypedArray()))
    println(Solution1559().containsCycle(listOf(
            "abb", "bzb", "bba"
    ).map { it.toCharArray() }.toTypedArray()))
}