package com.ypwang.easy

class Solution941 {
    fun validMountainArray(A: IntArray): Boolean {
        var i = 0
        while (i < A.size - 1) {
            if (A[i] >= A[i+1]) break
            i++
        }

        var j = A.lastIndex
        while (j > 0) {
            if (A[j-1] <= A[j]) break
            j--
        }

        return i != 0 && j != A.lastIndex && i == j
    }
}

fun main() {
    println(Solution941().validMountainArray(intArrayOf(14,82,89,84,79,70,70,68,67,66,63,60,58,54,44,43,32,28,26,25,22,15,13,12,10,8,7,5,4,3)))
}