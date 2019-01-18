package com.ypwang.easy

import java.lang.Exception

class Solution961 {
    fun repeatedNTimes(A: IntArray): Int {
        for (i in 0 until A.lastIndex) {
            if (A[i] == A[i+1]) {
                return A[i]
            }
        }

        for (i in 0 until A.size - 3) {
            if (A[i] == A[i+2]) {
                return A[i]
            } else if (A[i+1] == A[i+3]) {
                return A[i+1]
            }
        }
        throw Exception()
    }
}