package com.ypwang.hard

class Solution2267 {
    fun hasValidPath(grid: Array<CharArray>): Boolean {
        val visited = Array(100) { Array(100) { IntArray(101) } }
        val m = grid.size
        val n = grid[0].size

        fun visit(i: Int, j: Int, bal: Int): Boolean {
            var b = bal
            when (grid[i][j]) {
                '(' -> b++
                ')' -> b--
            }

            if (b < 0 || b > (m+n)/ 2 || visited[i][j][b] > 0)
                return false

            visited[i][j][b] = 1
            if ((i == m-1 && j == n-1 && b == 0) || (i < m-1 && visit(i+1, j, b)) || (j < n-1 && visit(i, j+1, b)))
                return true

            return false
        }


        return visit(0, 0, 0)
    }
}