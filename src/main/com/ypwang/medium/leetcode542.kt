package com.ypwang.medium

class Solution542 {
    fun updateMatrix(matrix: Array<IntArray>): Array<IntArray> {
        if (matrix.isEmpty())
            return arrayOf()

        val m = matrix.size
        val n = matrix[0].size

        // upper - left
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][j] != 0) {
                    matrix[i][j] = 100000
                    if (i > 0 && (matrix[i-1][j] + 1) < matrix[i][j]) matrix[i][j] = matrix[i-1][j] + 1
                    if (j > 0 && (matrix[i][j-1] + 1) < matrix[i][j]) matrix[i][j] = matrix[i][j-1] + 1
                }
            }
        }

        // down - right
        for (i in m-1 downTo 0) {
            for (j in n-1 downTo 0) {
                if (i < m-1 && (matrix[i+1][j] + 1) < matrix[i][j]) matrix[i][j] = matrix[i+1][j] + 1
                if (j < n-1 && (matrix[i][j+1] + 1) < matrix[i][j]) matrix[i][j] = matrix[i][j+1] + 1
            }
        }

        return matrix
    }
}

fun main() {
    println(Solution542().updateMatrix(arrayOf(
            intArrayOf(1, 1, 0, 0, 1, 0, 0, 1, 1, 0), intArrayOf(1, 0, 0, 1, 0, 1, 1, 1, 1, 1), intArrayOf(1, 1, 1, 0, 0, 1, 1, 1, 1, 0), intArrayOf(0, 1, 1, 1, 0, 1, 1, 1, 1, 1), intArrayOf(0, 0, 1, 1, 1, 1, 1, 1, 1, 0), intArrayOf(1, 1, 1, 1, 1, 1, 0, 1, 1, 1), intArrayOf(0, 1, 1, 1, 1, 1, 1, 0, 0, 1), intArrayOf(1, 1, 1, 1, 1, 0, 0, 1, 1, 1), intArrayOf(0, 1, 0, 1, 1, 0, 1, 1, 1, 1), intArrayOf(1, 1, 1, 0, 1, 0, 1, 1, 1, 1)
    )).map { it.toList() }.toList())
}