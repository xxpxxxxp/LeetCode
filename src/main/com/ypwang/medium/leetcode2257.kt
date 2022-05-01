package com.ypwang.medium

class Solution2257 {
    fun countUnguarded(m: Int, n: Int, guards: Array<IntArray>, walls: Array<IntArray>): Int {
        val grid = Array(m) { CharArray(n) }
        for ((x, y) in walls)
            grid[x][y] = 'W'

        for ((x, y) in guards)
            grid[x][y] = 'G'

        for ((px, py) in guards) {
            for ((dx, dy) in listOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)) {
                var x = px + dx
                var y = py + dy
                while ((x in 0 until m) && (y in 0 until n) && grid[x][y] != 'G' && grid[x][y] != 'W') {
                    grid[x][y] = 'P'
                    x += dx
                    y += dy
                }
            }
        }
        return (0 until m).sumBy { i ->
            (0 until n).count { j ->
                grid[i][j] !in setOf('G', 'W', 'P')
            }
        }
    }
}

fun main() {
    println(Solution2257().countUnguarded(4, 6,
        arrayOf(intArrayOf(0,0),intArrayOf(1,1),intArrayOf(2,3)),
        arrayOf(intArrayOf(0,1),intArrayOf(2,2),intArrayOf(1,4))
    ))
}