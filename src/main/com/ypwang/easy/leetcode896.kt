package com.ypwang.easy

class Solution896 {
    fun isMonotonic(A: IntArray): Boolean {
        val B = (0..(A.size-2)).map {
            when {
                A[it] < A[it+1] -> -1
                A[it] == A[it+1] -> 0
                A[it] > A[it+1] -> 1
                else -> {11111}
            }
        }
        return B.all { it >= 0 } || B.all { it <= 0 }
    }
}

fun main() {
    println(Solution896().isMonotonic(intArrayOf(1,2,3,4)))
}