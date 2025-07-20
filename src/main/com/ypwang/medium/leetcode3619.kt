package com.ypwang.medium

class Solution3619 {
    private fun helpIslands(grid: Array<IntArray>, i: Int, j: Int, m: Int, n: Int, sum: LongArray) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0)
            return

        sum[0] += grid[i][j].toLong()
        grid[i][j] = 0

        helpIslands(grid, i - 1, j, m, n, sum)
        helpIslands(grid, i + 1, j, m, n, sum)
        helpIslands(grid, i, j - 1, m, n, sum)
        helpIslands(grid, i, j + 1, m, n, sum)
    }

    fun countIslands(grid: Array<IntArray>, k: Int): Int {
        val m = grid.size
        val n = grid[0].size
        var count = 0

        for (i in 0..<m) {
            for (j in 0..<n) {
                if (grid[i][j] > 0) {
                    val sum = LongArray(1)
                    helpIslands(grid, i, j, m, n, sum)
                    if (sum[0] % k == 0L)
                        count++
                }
            }
        }

        return count
    }
}
