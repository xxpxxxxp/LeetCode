package com.ypwang.hard

class Solution1970 {
    fun latestDayToCross(row: Int, col: Int, cells: Array<IntArray>): Int {
        val grid = IntArray(row * col + 2) { it }

        fun root(i: Int): Int {
            if (i != grid[i]) grid[i] = root(grid[i])
            return grid[i]
        }

        fun union(i: Int, j: Int) {
            grid[root(i)] = root(j)
        }

        for ((x, y) in cells)
            grid[(x-1) * col + y] = -1

        // join head & tail
        for (i in 0 until col) {
            if (grid[i+1] > 0)
                union(i+1, 0)

            if (grid[(row-1) * col + i + 1] > 0)
                union((row-1) * col + i + 1, grid.lastIndex)
        }

        for ((i, arr) in cells.withIndex().reversed()) {
            if (root(0) == root(grid.lastIndex))
                return i+1

            val (x, y) = arr
            grid[(x-1) * col + y] = (x-1) * col + y

            if (x == 1)
                union(y, 0)

            if (x == row)
                union((row-1) * col + y, grid.lastIndex)

            for ((dx, dy) in listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)) {
                val cx = x - 1 + dx
                val cy = y - 1 + dy
                if (cx in 0 until row && cy in 0 until col && grid[cx * col + cy + 1] >= 0)
                    union(cx * col + cy + 1, (x-1) * col + y)
            }
        }

        return 0
    }
}
