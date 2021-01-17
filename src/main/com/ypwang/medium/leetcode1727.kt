package com.ypwang.medium

class Solution1727 {
    fun largestSubmatrix(matrix: Array<IntArray>): Int {
        var rst = 0
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (matrix[i][j] == 1 && i > 0) {
                    matrix[i][j] = 1 + matrix[i-1][j]
                }
            }

            val copy = matrix[i].sortedArrayDescending()
            for (j in copy.indices)
                rst = maxOf(rst, (j+1) * copy[j])
        }

        return rst
    }
}