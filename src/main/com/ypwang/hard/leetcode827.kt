package com.ypwang.hard

class Solution827 {
    fun largestIsland(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val group = Array(m){ IntArray(n) }

        var counter = 1
        val size = mutableMapOf<Int, Int>()

        fun dfs(i: Int, j: Int, groupIdx: Int): Int {
            group[i][j] = groupIdx
            var c = 1
            for ((dx, dy) in listOf(-1 to 0, 1 to 0, 0 to 1, 0 to -1)) {
                val x = i + dx
                val y = j + dy
                if (x in 0 until m && y in 0 until n && grid[x][y] == 1 && group[x][y] == 0) {
                    c += dfs(x, y , groupIdx)
                }
            }
            return c
        }

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 1 && group[i][j] == 0) {
                    size[counter] = dfs(i, j, counter)
                    counter++
                }
            }
        }

        var rst = size.values.maxOrNull() ?: 1
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 0 && group[i][j] == 0) {
                    rst = maxOf(rst, 1 + listOf(-1 to 0, 1 to 0, 0 to 1, 0 to -1)
                            .map { i + it.first to j + it.second }
                            .filter { it.first in 0 until m && it.second in 0 until n && grid[it.first][it.second] == 1 }
                            .map { group[it.first][it.second] }
                            .toSet()
                            .map { size[it]!! }
                            .sum())
                }
            }
        }

        return rst
    }
}

fun main() {
    println(Solution827().largestIsland(arrayOf(intArrayOf(1,0), intArrayOf(0,1))))
    println(Solution827().largestIsland(arrayOf(intArrayOf(1,1), intArrayOf(1,0))))
    println(Solution827().largestIsland(arrayOf(intArrayOf(1,1), intArrayOf(1,1))))
}