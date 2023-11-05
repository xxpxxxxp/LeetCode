package com.ypwang.easy

class Solution2923 {
    fun findChampion(grid: Array<IntArray>): Int =
        grid.withIndex().first { it.value.sum() == it.value.size - 1 }.index
}