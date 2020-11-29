package com.ypwang.medium

class Solution74 {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty()) {
            return false
        }

        var i = matrix.lastIndex
        var j = 0

        while (true) {
            if (i < 0 || j >= matrix[0].size) {
                return false
            }

            when {
                target > matrix[i][j] -> j++
                target < matrix[i][j] -> i--
                else -> return true
            }
        }
    }
}

fun main() {
    println(Solution74().searchMatrix(arrayOf(
            intArrayOf(1,3,5,7), intArrayOf(10,11,16,20), intArrayOf(23,30,34,50)
    ), 3))
}