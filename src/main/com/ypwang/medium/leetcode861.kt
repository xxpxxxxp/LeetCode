package com.ypwang.medium

class Solution861 {
    fun matrixScore(A: Array<IntArray>): Int {
        for (i in 0 until A.size) {
            if (A[i][0] == 0) {
                for (j in 0 until A[i].size) {
                    A[i][j] = 1 - A[i][j]
                }
            }
        }

        var sum = 0
        val size = A[0].size
        for (j in 0 until size) {
            sum += (1 shl (size - 1 - j)) * (0 until A.size).map { A[it][j] }.groupBy { it }.map { it.value.size }.max()!!
        }
        return sum
    }
}

fun main(args: Array<String>) {
    println(Solution861().matrixScore(
            arrayOf(
                    intArrayOf(0,0,1,1),
                    intArrayOf(1,0,1,0),
                    intArrayOf(1,1,0,0)
            )
    ))
}