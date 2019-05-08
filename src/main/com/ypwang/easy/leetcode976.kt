package com.ypwang.easy

class Solution976 {
    fun largestPerimeter(A: IntArray): Int {
        A.sort()
        for (i in A.lastIndex downTo 2) {
            if (A[i-2] + A[i-1] > A[i])
                return A[i-2] + A[i-1] + A[i]
        }

        return 0
    }
}