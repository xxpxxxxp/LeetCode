package com.ypwang.medium

class Solution1914 {
    fun rotateGrid(grid: Array<IntArray>, k: Int): Array<IntArray> {
        var top = 0
        var left = 0
        var bottom = grid.lastIndex
        var right = grid[0].lastIndex
        while (bottom > top && right > left) {
            val size = 2 * (bottom - top) + 2 * (right - left)
            var t = k % size

            while (t-- > 0) {
                val temp = grid[top][left]
                for(j in left until right)
                    grid[top][j] = grid[top][j+1]

                for(i in top until bottom)
                    grid[i][right] = grid[i+1][right]

                for(j in right downTo left+1)
                    grid[bottom][j] = grid[bottom][j-1]

                for(i in bottom downTo top+1)
                    grid[i][left] = grid[i-1][left]

                grid[top+1][left] = temp
            }

            top++
            left++
            bottom--
            right--
        }

        return grid
    }
}