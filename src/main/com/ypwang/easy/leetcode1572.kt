package com.ypwang.easy

class Solution1572 {
    fun diagonalSum(mat: Array<IntArray>): Int {
        val n = mat.size

        var sum = 0
        for (i in 0 until n) {
            sum += mat[i][i]
            if (i + i + 1 != n)
                sum += mat[i][n-i-1]
        }
        return sum
    }
}