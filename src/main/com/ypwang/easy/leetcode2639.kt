package com.ypwang.easy

class Solution2639 {
    fun findColumnWidth(grid: Array<IntArray>): IntArray =
        IntArray(grid[0].size) { j -> grid.map { it[j].toString().length }.max()!! }
}