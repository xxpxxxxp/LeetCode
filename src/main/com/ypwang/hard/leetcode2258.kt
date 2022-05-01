package com.ypwang.hard

import java.util.*

class Solution2258 {
    fun maximumMinutes(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val fires = mutableListOf<IntArray>()
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 1) {
                    fires.add(intArrayOf(i, j))
                }
            }
        }
        var l = -1
        var r = m * n
        while (l < r) {
            val mid = l + (r - l) / 2 + 1
            if (reachable(grid, mid, fires))
                l = mid
            else
                r = mid - 1
        }
        return if (l == m * n) 1000000000 else l
    }

    fun reachable(grid: Array<IntArray>, move: Int, fires: List<IntArray>): Boolean {
        var move = move
        val m = grid.size
        val n = grid[0].size
        val copy = grid.map { it.clone() }.toTypedArray()
        val fire: Queue<IntArray> = LinkedList()
        fire.addAll(fires)

        while (!fire.isEmpty() && move-- > 0)
            spread(fire, copy, false)

        val person: Queue<IntArray> = LinkedList()
        person.add(intArrayOf(0, 0))
        while (!person.isEmpty()) {
            spread(fire, copy, false)
            if (spread(person, copy, true)) return true
            if (copy[m - 1][n - 1] != 0) return false
        }
        return false
    }

    fun spread(queue: Queue<IntArray>, grid: Array<IntArray>, shouldReturn: Boolean): Boolean {
        val m = grid.size
        val n = grid[0].size
        var size = queue.size
        while (size-- > 0) {
            val (ox, oy) = queue.remove()
            for ((dx, dy) in listOf(-1 to 0, 1 to 0, 0 to 1, 0 to -1)) {
                val x = ox + dx
                val y = oy + dy
                if (shouldReturn && x == m - 1 && y == n - 1)
                    return true
                if (x in 0 until m && y in 0 until n && grid[x][y] == 0) {
                    grid[x][y] = -1
                    queue.add(intArrayOf(x, y))
                }
            }
        }
        return false
    }
}