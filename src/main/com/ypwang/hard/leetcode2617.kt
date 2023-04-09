package com.ypwang.hard

import java.util.*

class Solution2617 {
    fun minimumVisitedCells(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        if (m == 1 && n == 1)
            return 1

        val visited = Array(m) { BooleanArray(n) }
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.add(0 to 0)

        var dist = 1
        while (queue.isNotEmpty()) {
            for (z in 0 until queue.size) {
                val (x, y) = queue.poll()
                val `val` = grid[x][y]
                //check right
                for (col in 1..`val`) {
                    if (col + y >= n)
                        break
                    if (x == m - 1 && col + y == n - 1)
                        return dist + 1
                    if (grid[x][col + y] != 0 && !visited[x][col + y]) {
                        queue.add(x to col + y)
                        visited[x][col + y] = true
                    }
                }

                //check bottom
                for (row in 1..`val`) {
                    if (row + x >= m)
                        break
                    if (x + row == m - 1 && y == n - 1)
                        return dist + 1
                    if (grid[row + x][y] != 0 && !visited[row + x][y]) {
                        queue.add(row + x to y)
                        visited[row + x][y] = true
                    }
                }
            }
            dist++
        }

        return -1
    }
}