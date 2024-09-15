package com.ypwang.medium

import java.util.PriorityQueue

class Solution3286 {
    fun findSafeWalk(grid: List<List<Int>>, health: Int): Boolean {
        val m = grid.size
        val n = grid[0].size
        val counts = Array(m) { IntArray(n) { 0 } }
        val pq = PriorityQueue<IntArray>(compareBy { it[0] })
        pq.add(intArrayOf(health - grid[0][0], 0, 0))

        val directions = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
        while (pq.isNotEmpty()) {
            val (h, i, j) = pq.poll()
            if (i == m - 1 && j == n - 1)
                return true

            for ((dx, dy) in directions) {
                val x = i + dx
                val y = j + dy
                if (x in 0 until m && y in 0 until n && counts[x][y] < h - grid[x][y]) {
                    counts[x][y] = h - grid[x][y]
                    pq.add(intArrayOf(h - grid[x][y], x, y))
                }
            }
        }

        return false
    }
}
