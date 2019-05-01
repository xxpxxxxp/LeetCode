package com.ypwang.medium

class Solution1035 {
    fun maxUncrossedLines(A: IntArray, B: IntArray): Int {
        val sA = A.size + 1
        val sB = B.size + 1

        val cache = IntArray(sA * sB){0}

        for (i in 1 until sA) {
            for (j in 1 until sB) {
                cache[i * sB + j] = if (A[i-1] == B[j-1])  1 + cache[(i-1) * sB + j-1]
                else maxOf(cache[(i-1) * sB + j], cache[i * sB + j-1])
            }
        }

        return cache.last()
    }
}

fun main() {
    println(Solution1035().maxUncrossedLines(intArrayOf(2,5,1,2,5), intArrayOf(10,5,2,1,5,2)))
}