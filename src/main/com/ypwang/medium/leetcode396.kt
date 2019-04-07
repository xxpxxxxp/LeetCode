package com.ypwang.medium

class Solution396 {
    fun maxRotateFunction(A: IntArray): Int {
        var start = A.withIndex().sumBy { it.index * it.value }
        val sum = A.sum()
        var max = start

        for (i in A.lastIndex downTo 1) {
            start += sum - A[i] * A.size
            max = maxOf(max, start)
        }

        return max
    }
}

fun main() {
    println(Solution396().maxRotateFunction(intArrayOf(4,3,2,6)))
}