package com.ypwang.hard

class Solution1728 {
    private class Solve(
        val grid: Array<String>,
        private val foodPos: Int,
        private val mouseJump: Int,
        private val catJump: Int
    ) {
        private val m = grid.size
        private val n = grid[0].length

        private val directions = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
        private val cache = mutableMapOf<Triple<Int, Int, Int>, Boolean>()

        private fun recur(past: Int, catPos: Int, mousePos: Int): Boolean {
            val mouseMove = (past % 2) == 0
            for ((di, dj) in directions) {
                if (mouseMove) {
                    for (c in 0..mouseJump) {
                        val ai = c * di + mousePos / n
                        val aj = c * dj + mousePos % n

                        if (ai in 0 until m && aj in 0 until n && grid[ai][aj] != '#') {
                            if (search(past + 1, catPos, ai * n + aj))
                                return true
                        }
                        else
                            break
                    }
                } else {
                    for (c in 0..catJump) {
                        val ai = c * di + catPos / n
                        val aj = c * dj + catPos % n

                        if (ai in 0 until m && aj in 0 until n && grid[ai][aj] != '#') {
                            if (!search(past + 1, ai * n + aj, mousePos))
                                return false
                        } else
                            break
                    }
                }
            }

            return !mouseMove
        }

        fun search(past: Int, catPos: Int, mousePos: Int): Boolean {
            if (mousePos == foodPos)
                return true

            if (catPos == foodPos || catPos == mousePos || past > 2 * m * n)
                return false

            val t = cache.getOrPut(Triple(past, catPos, mousePos)) { recur(past, catPos, mousePos) }
            return t
        }
    }

    fun canMouseWin(grid: Array<String>, catJump: Int, mouseJump: Int): Boolean {
        var catPos = 0
        var mousePos = 0
        var foodPos = 0

        for (i in grid.indices) {
            for (j in grid[0].indices) {
                when (grid[i][j]) {
                    'C' -> catPos = i * grid[0].length + j
                    'M' -> mousePos = i * grid[0].length + j
                    'F' -> foodPos = i * grid[0].length + j
                }
            }
        }

        return Solve(grid, foodPos, mouseJump, catJump).search(0, catPos, mousePos)
    }
}

fun main() {
    println(Solution1728().canMouseWin(arrayOf(
        "####F","#C...","M...."
    ), 1, 2))
}