package com.ypwang.easy

class Solution3127 {
    fun canMakeSquare(grid: Array<CharArray>): Boolean {
        for (i in 0 until 2) {
            for (j in 0 until 2) {
                var cw = 0
                if (grid[i][j] == 'W')
                    cw++
                if (grid[i][j+1] == 'W')
                    cw++
                if (grid[i+1][j] == 'W')
                    cw++
                if (grid[i+1][j+1] == 'W')
                    cw++

                if (cw <= 1 || cw >= 3)
                    return true
            }
        }
        return false
    }
}
