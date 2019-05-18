package com.ypwang.hard

class Solution41 {
    fun firstMissingPositive(A: IntArray): Int {
        for (i in 0 until A.size)
            while (A[i] in 1..A.size && A[A[i] - 1] != A[i]) {
                val t = A[A[i] - 1]
                A[A[i] - 1] = A[i]
                A[i] = t
            }

        for (i in 0 until A.size)
            if (A[i] != i + 1)
                return i + 1

        return A.size + 1
    }
}

fun main() {
    println(Solution41().firstMissingPositive(intArrayOf(3,3,2)))
}