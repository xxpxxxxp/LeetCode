package com.ypwang.medium

class Solution1568 {
    fun minDays(grid: Array<IntArray>): Int {
        val seen = mutableSetOf<Int>()

        val m = grid.size
        val n = grid[0].size

        val dfn = IntArray(1 shl 10)
        val low = IntArray(1 shl 10)
        val parent = IntArray(1 shl 10){-1}
        var count = 0

        var existArticulation = false

        // return if any articulation point
        fun findArticulationDFS(i: Int, j: Int) {
            var child = 0
            val hash = (i shl 5) or j

            dfn[hash] = count
            low[hash] = count
            seen.add(hash)

            count++

            for ((dx, dy) in listOf(-1 to 0, 0 to 1, 1 to 0, 0 to -1)) {
                val nx = i + dx
                val ny = j + dy

                if (nx in 0 until m && ny in 0 until n && grid[nx][ny] == 1) {
                    val childHash = (nx shl 5) or ny
                    if (childHash !in seen) {
                        child++
                        parent[childHash] = hash

                        findArticulationDFS(nx, ny)

                        low[hash] = minOf(low[hash], low[childHash])

                        if (parent[hash] == -1 && child >= 2)
                            existArticulation = true

                        if (parent[hash] != -1 && low[childHash] >= dfn[hash])
                            existArticulation = true
                    } else if (parent[hash] != childHash) {
                        low[hash] = minOf(low[hash], dfn[childHash])
                    }
                }
            }
        }

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 1) {
                    val hash = (i shl 5) or j
                    if (hash !in seen) {
                        if (seen.isNotEmpty())
                            return 0

                        findArticulationDFS(i, j)
                    }
                }
            }
        }

        return if (existArticulation) 1 else 2
    }
}

fun main() {
    println(Solution1568().minDays(arrayOf(
            intArrayOf(1,0,1,0)
    )))
}