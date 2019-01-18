package com.ypwang.medium

class Solution718 {
    fun findLength(A: IntArray, B: IntArray): Int {
        val m = A.size
        val n = B.size

        // x in A, y in B
        fun index(x: Int, y: Int) = x + y * m

        val matrix = IntArray(m * n){0}

        var max = 0

        // test A[i] == B[n - 1]
        for (i in 0 until m) {
            matrix[index(i, n-1)] = if (A[i] == B[n-1]) {
                max = 1
                1
            } else 0
        }

        // test A[m - 1] = B[i]
        for (i in 0 until n) {
            matrix[index(m-1, i)] = if (A[m-1] == B[i]) {
                max = 1
                1
            } else 0
        }

        for (i in m - 2 downTo 0) {
            for (j in n - 2 downTo 0) {
                matrix[index(i, j)] =
                        if (A[i] == B[j]) {
                            val v = 1 + matrix[index(i+1, j+1)]
                            if (v > max) {
                                max = v
                            }
                            v
                        }
                        else 0
            }
        }

        return max
    }
}

fun main(args: Array<String>) {
    println(Solution718().findLength(intArrayOf(1,2,3,2,1), intArrayOf(3,2,1,4,7)))
}