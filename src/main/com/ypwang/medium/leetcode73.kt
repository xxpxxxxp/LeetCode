package com.ypwang.medium

class Solution73 {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        if (matrix.isEmpty()) {
            return
        }

        val m = matrix.size
        val n = matrix[0].size
        var firstColZero = false

        for (i in 0 until m) {
            if (matrix[i][0] == 0) {
                firstColZero = true
            }

            for (j in 0 until n) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0
                    if (j > 0) {
                        matrix[0][j] = 0
                    }
                }
            }
        }

        for (i in 1 until m) {
            for (j in 1 until n) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0
            }
        }

        if (matrix[0][0] == 0) {
            for (j in 1 until n) {
                matrix[0][j] = 0
            }
        }

        if (firstColZero) {
            for (i in 0 until m) {
                matrix[i][0] = 0
            }
        }
    }
}

fun main(args: Array<String>) {
    println(Solution73().setZeroes(arrayOf(intArrayOf(1), intArrayOf(0))))
}