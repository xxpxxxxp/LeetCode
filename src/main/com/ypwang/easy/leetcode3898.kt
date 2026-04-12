package com.ypwang.easy

class Solution3898 {
    fun findDegrees(matrix: Array<IntArray>): IntArray {
        val rst = IntArray(matrix.size)

        for ((i, row) in matrix.withIndex()) {
            for (j in i+1 until row.size) {
                if (row[j] == 1) {
                    rst[i]++
                    rst[j]++
                }
            }
        }

        return rst
    }
}
