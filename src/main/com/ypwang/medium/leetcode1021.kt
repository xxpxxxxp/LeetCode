package com.ypwang.medium

class Solution1021 {
    fun maxScoreSightseeingPair(A: IntArray): Int {
        var max = Int.MIN_VALUE
        var cur = A.first()

        for (i in 1 until A.size) {
            if ((A[i] + cur - 1) > max) {
                max = (A[i] + cur - 1)
            }

            cur = maxOf(A[i], cur - 1)
        }

        return max
    }
}

fun main() {
    println(Solution1021().maxScoreSightseeingPair(intArrayOf(8,1,5,2,6)))
}