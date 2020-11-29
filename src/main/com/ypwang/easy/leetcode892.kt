package com.ypwang.easy

class Solution892 {
    fun surfaceArea(grid: Array<IntArray>): Int {
        val x = grid.size
        val y = grid[0].size

        var dup = 0
        for (i in 0 until x) {
            for (j in 0 until y) {
                if (i+1 < x) {
                    dup += kotlin.math.min(grid[i][j], grid[i+1][j])
                }
                if (j+1 < y) {
                    dup += kotlin.math.min(grid[i][j], grid[i][j+1])
                }
            }
        }

        return grid.sumBy { it.sum() } * 4 + grid.sumBy { r -> r.count{ it > 0 } } * 2 - dup * 2
    }
}

fun main() {
    println(Solution892().surfaceArea(arrayOf(intArrayOf(1,2), intArrayOf(3,4))))
}