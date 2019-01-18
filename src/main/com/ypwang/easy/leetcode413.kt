package com.ypwang.easy

class Solution413 {
    fun numberOfArithmeticSlices(A: IntArray): Int {
        var curr = 0
        var sum = 0
        for (i in 2 until A.size) {
            if (A[i-1] - A[i-2] == A[i] - A[i-1]) {
                curr++
                sum += curr
            } else {
                curr = 0
            }
        }
        return sum
    }
}