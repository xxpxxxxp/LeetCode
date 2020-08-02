package com.ypwang.medium

class Solution1536 {
    fun minSwaps(grid: Array<IntArray>): Int {
        val list = grid.map { it.takeLastWhile { i -> i == 0 }.count() }.toMutableList()

        var rst = 0
        for (i in grid.indices) {
            val idx = list.indexOfFirst { it >= (grid.size - i - 1) }
            if (idx == -1)
                return -1

            rst += idx
            list.removeAt(idx)
        }

        return rst
    }
}

fun main() {
    println(Solution1536().minSwaps(arrayOf(
            intArrayOf(0,0,1), intArrayOf(1,1,0), intArrayOf(1,0,0)
    )))
}