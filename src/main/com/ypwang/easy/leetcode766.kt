package com.ypwang.easy

class Solution766 {
    fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
        return (0 until (matrix.size-1)).all { matrix[it].take(matrix[it].size-1) != matrix[it+1].takeLast(matrix[it+1].size-1) }
    }
}

fun main(args: Array<String>) {
    println(Solution766().isToeplitzMatrix(arrayOf(intArrayOf())))
}