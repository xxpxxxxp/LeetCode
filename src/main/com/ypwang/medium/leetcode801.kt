package com.ypwang.medium

class Solution801 {
    fun minSwap(A: IntArray, B: IntArray): Int {
        var s1 = 0  // denote A, B
        var s2 = 1  // denote B, A

        for (i in 1 until A.size) {
            var s1c: Int
            var s2c: Int
            if (A[i] > A[i-1] && B[i] > B[i-1]) {
                s1c = s1
                s2c = s2 + 1
            } else {
                s1c = s2
                s2c = s1 + 1
            }

            if (B[i] > A[i-1] && A[i] > B[i-1]) {
                s1c = minOf(s1c, s2)
                s2c = minOf(s2c, s1 + 1)
            } else {
                s1c = minOf(s1c, s1)
                s2c = minOf(s2c, s2 + 1)
            }

            s1 = s1c
            s2 = s2c
        }

        return minOf(s1, s2)
    }
}

fun main() {
    println(Solution801().minSwap(intArrayOf(0,1,4,6,8), intArrayOf(1,2,2,7,10)))
}