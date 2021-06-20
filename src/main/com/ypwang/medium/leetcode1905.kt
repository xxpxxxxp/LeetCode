package com.ypwang.medium

class Solution1905 {
    fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
        fun dfs(i: Int, j: Int): Boolean {
            if (i !in grid2.indices || j !in grid2[0].indices || grid2[i][j] == 0)
                return true

            grid2[i][j] = 0
            return (grid1[i][j] == 1) and dfs(i-1, j) and dfs(i+1, j) and dfs(i, j-1) and dfs(i, j+1)
        }

        var rst = 0
        for (i in grid2.indices) {
            for (j in grid2[0].indices) {
                if (grid2[i][j] == 1 && dfs(i, j))
                    rst++
            }
        }

        return rst
    }
}