package com.ypwang.medium

class Solution1926 {
    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
        val m = maze.size
        val n = maze[0].size

        val seen = mutableSetOf<Int>()
        var bfs = setOf(entrance[0] * n + entrance[1])
        var count = 0

        while (bfs.isNotEmpty()) {
            seen.addAll(bfs)
            val next = mutableSetOf<Int>()

            for (i in bfs) {
                val x = i / n
                val y = i % n
                if (count > 0 && (x == 0 || x == m-1 || y == 0 || y == n-1))
                    return count

                for ((dx, dy) in listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)) {
                    val nx = x + dx
                    val ny = y + dy

                    if (nx in 0 until m && ny in 0 until n && maze[nx][ny] == '.') {
                        val j = nx * n + ny
                        if (j !in seen)
                            next.add(j)
                    }
                }
            }

            bfs = next
            count++
        }

        return -1
    }
}