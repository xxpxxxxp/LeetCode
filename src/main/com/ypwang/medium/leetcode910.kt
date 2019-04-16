package com.ypwang.medium

class Solution910 {
    fun smallestRangeII(A: IntArray, K: Int): Int {
        if (A.size < 2) return 0

        A.sort()

        val first = A.first()
        val last = A.last()
        var range = last - first

        for (i in 0 until A.lastIndex) {
            val t = maxOf(last - K, A[i] + K) - minOf(first + K, A[i+1] - K)
            if (t < range) range = t
        }

        return range
    }
}

fun main() {
    println(Solution910().smallestRangeII(intArrayOf(0, 10), 2))
}