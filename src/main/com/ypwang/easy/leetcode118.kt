package com.ypwang.easy

class Solution118 {
    fun generate(numRows: Int): List<List<Int>> {
        val rst = mutableListOf<List<Int>>()
        if (numRows == 0) {
            return rst
        }
        rst.add(listOf(1))

        for (i in 1 until numRows) {
            val left = rst[i-1].toMutableList()
            left.add(0, 0)
            val right = rst[i-1].toMutableList()
            right.add(0)
            rst.add(left.zip(right).map { it.first + it.second })
        }

        return rst
    }
}