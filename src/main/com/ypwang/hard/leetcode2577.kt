package com.ypwang.hard

import java.util.*

class Solution2577 {
    fun minimumTime(grid: Array<IntArray>): Int {
        if (grid[0][1] > 1 && grid[1][0] > 1)
            return -1
        val m = grid.size
        val n = grid[0].size
        val dirs = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
        val visited = Array(m) { BooleanArray(n) }
        val pq = PriorityQueue<IntArray>(compareBy { it[0] })
        pq.offer(intArrayOf(grid[0][0], 0, 0))
        while (pq.isNotEmpty()) {
            val (time, row, col) = pq.poll()
            if (row == m - 1 && col == n - 1)
                return time
            if (visited[row][col])
                continue
            visited[row][col] = true
            for ((x, y) in dirs) {
                val r = row + x
                val c = col + y
                if (r !in 0 until m || c !in 0 until n || visited[r][c])
                    continue
                val wait = if ((grid[r][c] - time) % 2 == 0) 1 else 0
                pq.offer(intArrayOf(maxOf(grid[r][c] + wait, time + 1), r, c))
            }
        }
        return -1
    }
}