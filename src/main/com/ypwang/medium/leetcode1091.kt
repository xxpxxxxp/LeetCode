package com.ypwang.medium

class Solution1091 {
    private val inc = listOf(
        -1 to -1, -1 to 0, -1 to 1, 0 to -1, 0 to 1, 1 to -1, 1 to 0, 1 to 1
    )

    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        val size = grid.size

        if (grid[0][0] != 0 || grid[size-1][size-1] != 0) return -1

        grid[0][0] = 2
        val final = size * size - 1
        var cur = setOf(0)
        var count = 1

        while (cur.isNotEmpty()) {
            if (final in cur) {
                return count
            }

            val next = mutableSetOf<Int>()

            for (point in cur) {
                val x = point / size
                val y = point % size

                for (i in inc) {
                    val xp = x + i.first
                    val yp = y + i.second

                    if (xp in 0 until size && yp in 0 until size && grid[xp][yp] == 0) {
                        grid[xp][yp] = 2
                        next.add(xp * size + yp)
                    }
                }

                cur = next
            }

            count++
        }

        return -1
    }
}

fun main() {
    println(Solution1091().shortestPathBinaryMatrix(arrayOf(intArrayOf(0, 1), intArrayOf(1,0))))
}