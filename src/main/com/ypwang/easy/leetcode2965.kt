package com.ypwang.easy

class Solution2965 {
    fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
        val exist = BooleanArray(grid.size * grid.size)
        val rst = intArrayOf(0, 0)
        grid.forEach {
            it.forEach { i ->
                if (exist[i-1])
                    rst[0] = i
                exist[i-1] = true
            }
        }
        rst[1] = exist.withIndex().first { it.value == false }!!.index + 1

        return rst
    }
}