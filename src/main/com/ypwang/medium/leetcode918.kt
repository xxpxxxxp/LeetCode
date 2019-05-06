package com.ypwang.medium

import java.util.*

class Solution918 {
    fun maxSubarraySumCircular(A: IntArray): Int {
        val sum = IntArray(2 * A.size + 1){0}
        for (i in 0 until 2 * A.size)
            sum[i+1] = sum[i] + A[i % A.size]

        var rst = A[0]
        val range = LinkedList<Int>()
        range.add(0)

        for (i in 1..2 * A.size) {
            if (range.first() < i - A.size) {
                range.removeFirst()
            }

            if (sum[i] - sum[range.first()] > rst)
                rst = sum[i] - sum[range.first()]

            while (range.isNotEmpty() && sum[range.last()] > sum[i])
                range.removeLast()

            range.add(i)
        }

        return rst
    }
}

fun main() {
    println(Solution918().maxSubarraySumCircular(intArrayOf(5,-3,5)))
}