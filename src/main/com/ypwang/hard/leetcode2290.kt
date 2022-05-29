package com.ypwang.hard

import java.util.*

class Solution2290 {
    private val step = listOf(0 to 1, 0 to -1, -1 to 0, 1 to 0)

    fun minimumObstacles(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val dist = Array(m) { IntArray(n) { Int.MAX_VALUE } }
        dist[0][0] = grid[0][0]
        val pq = PriorityQueue<IntArray>(compareBy { it[0] })
        pq.offer(intArrayOf(dist[0][0], 0, 0))

        while (pq.isNotEmpty()) {
            val (o, r, c) = pq.poll()
            if (r == m - 1 && c == n - 1) {
                return o
            }

            for ((x, y) in step) {
                val i = r + x
                val j = c + y
                if (i in 0 until m && j in 0 until n && o + grid[i][j] < dist[i][j]) {
                    dist[i][j] = o + grid[i][j]
                    pq.offer(intArrayOf(dist[i][j], i, j))
                }
            }
        }

        return dist[m - 1][n - 1]
    }
}