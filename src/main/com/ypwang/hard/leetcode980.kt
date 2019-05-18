package com.ypwang.hard

class Solution980 {
    fun uniquePathsIII(grid: Array<IntArray>): Int {
        var steps = 0

        var r = 0
        var c = 0

        for (i in 0 until grid.size) {
            for (j in 0 until grid[0].size) {
                when (grid[i][j]) {
                    1 -> {
                        r = i
                        c = j
                    }
                    0, 2 -> steps++
                }
            }
        }

        val rst = mutableListOf<Pair<Int, Int>>()
        fun backTrace(row: Int, col: Int, step: Int): Int {
            if (step == steps) return if (grid[row][col] == 2) 1 else 0

            val cur = grid[row][col]
            if (cur != 0 && (cur != 1 || step != 0)) return 0

            rst.add(row to col)
            var count = 0
            if (cur == 0) grid[row][col] = 0x10

            if (row > 0) count += backTrace(row-1, col, step+1)
            if (row < grid.size-1) count += backTrace(row+1, col, step+1)
            if (col > 0) count += backTrace(row, col-1, step+1)
            if (col < grid[0].size-1) count += backTrace(row, col+1, step+1)

            rst.removeAt(rst.lastIndex)
            if (cur == 0) grid[row][col] = 0

            return count
        }

        return backTrace(r, c, 0)
    }
}

fun main() {
    println(Solution980().uniquePathsIII(arrayOf(
            intArrayOf(1,0,0,0),
            intArrayOf(0,0,0,0),
            intArrayOf(0,0,2,-1))))
}