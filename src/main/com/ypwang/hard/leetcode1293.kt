package com.ypwang.hard

class Solution1293 {
    fun shortestPath(grid: Array<IntArray>, k: Int): Int {
        var queue = setOf(Triple(0,0,0))
        val seen = mutableSetOf<Triple<Int, Int, Int>>()

        var step = 0
        while (queue.isNotEmpty()) {
            seen.addAll(queue)
            val next = mutableSetOf<Triple<Int, Int, Int>>()

            for ((x, y, s) in queue) {
                if (x == grid.lastIndex && y == grid[0].lastIndex) return step

                if (grid[x][y] == 0 || s + 1 <= k) {
                    for ((m, n) in listOf(-1 to 0, 0 to -1, 1 to 0, 0 to 1)) {
                        val nx = x + m
                        val ny = y + n
                        val n = Triple(nx, ny, s + grid[x][y])
                        if (nx in grid.indices && ny in grid[0].indices && n !in seen)
                            next.add(n)
                    }
                }
            }

            queue = next
            step++
        }

        return -1
    }
}

fun main() {
    println(Solution1293().shortestPath(arrayOf(
            intArrayOf(0,0,1,0,0,0,0,1,0,1,1,0,0,1,1),intArrayOf(0,0,0,1,1,0,0,1,1,0,1,0,0,0,1),intArrayOf(1,1,0,0,0,0,0,1,0,1,0,0,1,0,0),intArrayOf(1,0,1,1,1,1,0,0,1,1,0,1,0,0,1),intArrayOf(1,0,0,0,1,1,0,1,1,0,0,1,1,1,1),intArrayOf(0,0,0,1,1,1,0,1,1,0,0,1,1,1,1),intArrayOf(0,0,0,1,0,1,0,0,0,0,1,1,0,1,1),intArrayOf(1,0,0,1,1,1,1,1,1,0,0,0,1,1,0),intArrayOf(0,0,1,0,0,1,1,1,1,1,0,1,0,0,0),intArrayOf(0,0,0,1,1,0,0,1,1,1,1,1,1,0,0),intArrayOf(0,0,0,0,1,1,1,0,0,1,1,1,0,1,0)
    ), 27))
}