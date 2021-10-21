package com.ypwang.medium

class Solution845 {
    fun longestMountain(A: IntArray): Int {
        val left = IntArray(A.size){0}
        val right = IntArray(A.size){0}

        for (i in 1 until A.size) {
            if (A[i] > A[i-1]) {
                left[i] = left[i-1] + 1
            }
        }

        for (i in A.lastIndex-1 downTo 0) {
            if (A[i] > A[i+1])
                right[i] = right[i+1] + 1
        }

        return left.zip(right).filter { it.first > 0 && it.second > 0 }.map { it.first + it.second + 1 }.maxOrNull() ?: 0
    }
}

fun main() {
    println(Solution845().longestMountain(intArrayOf(2,2,2)))
}