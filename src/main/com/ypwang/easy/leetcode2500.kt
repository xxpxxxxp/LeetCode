package com.ypwang.easy

class Solution2500 {
    fun deleteGreatestValue(grid: Array<IntArray>): Int {
        grid.forEach { it.sort() }
        return grid[0].indices.map { i -> grid.map { it[i] }.max()!! }.sum()
    }
}