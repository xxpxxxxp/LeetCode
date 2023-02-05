package com.ypwang.medium

class Solution2556 {
    private fun dfs(grid: Array<IntArray>, i: Int, j: Int): Boolean {
        if (i+1 == grid.size && j+1 == grid[0].size)
            return true

        if (i >= grid.size || j >= grid[0].size || grid[i][j] == 0)
            return false

        grid[i][j] = 0
        return dfs(grid, i+1, j) || dfs(grid, i, j+1)
    }

    fun isPossibleToCutPath(grid: Array<IntArray>): Boolean {
        if (!dfs(grid, 0, 0))
            return true

        grid[0][0] = 1
        return !dfs(grid, 0, 0)
    }
}
