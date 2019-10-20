package com.ypwang.hard

class Solution749 {
    fun containVirus(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        var count = 0
        while (true) {
            val seen = mutableSetOf<Int>()
            val regions = mutableListOf<MutableList<Int>>()
            val surroundings = mutableListOf<MutableSet<Int>>()
            val walls = mutableListOf<Int>()

            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (grid[i][j] == 1 && i * n + j !in seen) {
                        val region = mutableListOf<Int>()
                        val surrounding = mutableSetOf<Int>()
                        var wall = 0

                        fun dfs(x: Int, y: Int) {
                            region.add(x * n + y)
                            seen.add(x * n + y)

                            for ((sx, sy) in listOf(-1 to 0, 0 to -1, 1 to 0, 0 to 1)) {
                                val dx = x + sx
                                val dy = y + sy
                                if (dx in 0 until m && dy in 0 until n) {
                                    if (grid[dx][dy] == 1 && dx * n + dy !in seen)
                                        dfs(dx, dy)
                                    else if (grid[dx][dy] == 0) {
                                        surrounding.add(dx * n + dy)
                                        wall++
                                    }
                                }
                            }
                        }

                        dfs(i, j)

                        regions.add(region)
                        surroundings.add(surrounding)
                        walls.add(wall)
                    }
                }
            }

            if (regions.isEmpty()) break
            var idx = -1
            var v = -1
            for ((i, c) in surroundings.withIndex()) {
                if (c.size > v) {
                    idx = i
                    v = c.size
                }
            }

            count += walls[idx]

            // selected regions turn to 2 (blocked)
            regions[idx].forEach { grid[it/n][it%n] = 2 }
            surroundings.withIndex().filter { it.index != idx }.forEach {
                it.value.forEach { h -> grid[h/n][h%n] = 1 }
            }
        }

        return count
    }
}

fun main() {
    println(Solution749().containVirus(arrayOf(
            intArrayOf(1)
    )))
    println(Solution749().containVirus(arrayOf(
            intArrayOf(0,1,0,0,0,0,0,1),intArrayOf(0,1,0,0,0,0,0,1),intArrayOf(0,0,0,0,0,0,0,1),intArrayOf(0,0,0,0,0,0,0,0)
    )))
    println(Solution749().containVirus(arrayOf(
            intArrayOf(1,1,1),intArrayOf(1,0,1),intArrayOf(1,1,1)
    )))
    println(Solution749().containVirus(arrayOf(
            intArrayOf(1,1,1,0,0,0,0,0,0),intArrayOf(1,0,1,0,1,1,1,1,1),intArrayOf(1,1,1,0,0,0,0,0,0)
    )))
}