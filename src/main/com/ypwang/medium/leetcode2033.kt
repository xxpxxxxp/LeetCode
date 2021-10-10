package com.ypwang.medium

class Solution2033 {
    fun minOperations(grid: Array<IntArray>, x: Int): Int {
        val arr = grid.flatMap { it.toList() }.sorted()
        var rst = 0
        val mid = arr[(arr.size - 1) / 2]
        for (c in arr) {
            val diff = Math.abs(c - mid)
            if (diff % x != 0)
                return -1

            rst += diff / x
        }

        return rst
    }
}