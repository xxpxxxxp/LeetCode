package com.ypwang.medium

class Solution4084 {
    fun lastVisitedCell(grid: Array<CharArray>): IntArray {
        val m = grid.size
        val n = grid[0].size
        val visited = Array(m) { BooleanArray(n) }

        var r = 0
        var c = 0
        visited[0][0] = true

        while (true) {
            val dir = grid[r][c]
            var nr = r
            var nc = c

            when (dir) {
                'U' -> nr--
                'D' -> nr++
                'L' -> nc--
                'R' -> nc++
            }

            if (nr !in 0 until m || nc !in 0 until n || visited[nr][nc])
                return intArrayOf(r, c)

            visited[nr][nc] = true
            r = nr
            c = nc
        }
    }
}
