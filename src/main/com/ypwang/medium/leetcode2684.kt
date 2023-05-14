package com.ypwang.medium

class Solution2684 {
    fun maxMoves(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val cache = Array(m) { IntArray(n) }
        var rst = 0

        for (j in 0 until n) {
            for (i in 0 until m) {
                if (j > 0 && cache[i][j] == 0)
                    continue
                for (di in listOf(-1, 0, 1)) {
                    val x = i + di
                    val y = j + 1
                    if (x in 0 until m && y in 0 until n && grid[x][y] > grid[i][j]) {
                        cache[x][y] = maxOf(cache[x][y], 1 + cache[i][j])
                        rst = maxOf(rst, cache[x][y])
                    }
                }
            }
        }

        return rst
    }
}

fun main() {
    println(Solution2684().maxMoves(arrayOf(
        intArrayOf(3,2,4), intArrayOf(2,1,9), intArrayOf(1,1,7)
    )))
}