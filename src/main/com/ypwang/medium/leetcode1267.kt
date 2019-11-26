package com.ypwang.medium

class Solution1267 {
    fun countServers(grid: Array<IntArray>): Int {
        val cx = IntArray(250)
        val cy = IntArray(250)

        grid.withIndex().forEach { (x, row) -> row.withIndex().forEach { (y, v) -> if (v == 1) { cx[x]++; cy[y]++ }}}
        return grid.withIndex().sumBy { (x, row) -> row.withIndex().count { (y, v) -> v == 1 && (cx[x] > 1 || cy[y] > 1) } }
    }
}