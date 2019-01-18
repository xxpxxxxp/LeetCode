package com.ypwang.easy

class Solution852 {
    fun peakIndexInMountainArray(A: IntArray): Int {
        if (A.isEmpty()) {
            return 0
        }
        for (i in 0..(A.size-2)) {
            if (A[i+1] > A[i]) {
                continue
            } else {
                return i
            }
        }
        return A.size-1
    }
}

fun main(args: Array<String>) {
    println(Solution852().peakIndexInMountainArray(intArrayOf(0,1,0)))
}