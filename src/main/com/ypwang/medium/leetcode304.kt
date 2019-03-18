package com.ypwang.medium

class NumMatrix(matrix: Array<IntArray>) {
    var ma: Array<IntArray>

    init {
        for (j in 0 until matrix.size) {
            for (i in 1 until matrix[0].size) {
                matrix[j][i] = matrix[j][i] + matrix[j][i - 1]
            }

            if (j > 0) {
                for (i in 0 until matrix[0].size) {
                    matrix[j][i] = matrix[j][i] + matrix[j - 1][i]
                }
            }
        }
        ma = matrix
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        var rst = ma[row2][col2]

        if (row1 >= 1) {
            rst -= ma[row1 - 1][col2]
        }

        if (col1 >= 1) {
            rst -= ma[row2][col1 - 1]
        }

        if (row1 >= 1 && col1 >= 1) {
            rst += ma[row1 - 1][col1 - 1]
        }


        return rst
    }
}

fun main() {
    val m = NumMatrix(arrayOf(intArrayOf(3, 0, 1, 4, 2), intArrayOf(5, 6, 3, 2, 1), intArrayOf(1, 2, 0, 1, 5), intArrayOf(4, 1, 0, 1, 7), intArrayOf(1, 0, 3, 0, 5)))
    println(m.sumRegion(2, 1, 4, 3))
    println(m.sumRegion(1,1,2,2))
    println(m.sumRegion(1,2,2,4))
}