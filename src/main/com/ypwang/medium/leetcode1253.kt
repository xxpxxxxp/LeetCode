package com.ypwang.medium

class Solution1253 {
    fun reconstructMatrix(upper: Int, lower: Int, colsum: IntArray): List<List<Int>> {
        val both = colsum.count { it == 2 }
        var u = upper - both
        var l = lower - both
        if (upper + lower != colsum.sum() || u < 0 || l < 0) return listOf()

        val rst = arrayOf(IntArray(colsum.size), IntArray(colsum.size))

        for ((i, v) in colsum.withIndex()) {
            when (v) {
                0 -> {}
                1 -> {
                    if (u > 0) {
                        rst[0][i] = 1
                        u--
                    } else {
                        rst[1][i] = 1
                    }
                }
                2 -> { rst[0][i] = 1; rst[1][i] = 1 }
            }
        }

        return rst.map { it.toList() }
    }
}