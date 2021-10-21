package com.ypwang.medium

class Solution807 {
    fun maxIncreaseKeepingSkyline(grid: Array<IntArray>): Int {
        val verticalMax = grid.map { it.maxOrNull()!! }
        val z = grid[0].size
        val horizontalMax = (0 until z).map { i -> (0 until grid.size).map { grid[it][i] }.maxOrNull()!! }

        return grid.mapIndexed { x, ints ->
            ints.mapIndexed { y, value ->
                Math.min(verticalMax[x], horizontalMax[y]) - value
            }.sum()
        }.sum()
    }
}

fun main() {
    println(Solution807().maxIncreaseKeepingSkyline(arrayOf(
            intArrayOf(3,0,8,4),
            intArrayOf(2,4,5,7),
            intArrayOf(9,2,6,3),
            intArrayOf(0,3,1,0)
    )))
}