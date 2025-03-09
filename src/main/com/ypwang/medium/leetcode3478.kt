package com.ypwang.medium

import java.util.PriorityQueue

class Solution3478 {
    fun findMaxSum(nums1: IntArray, nums2: IntArray, k: Int): LongArray {
        val t = nums1.zip(nums2).withIndex().map { (i, v) ->
            Triple(i, v.first, v.second)
        }.sortedBy { it.second }

        var sum = 0L
        var pre = Int.MIN_VALUE
        var preSum = 0L
        val rst = LongArray(nums1.size)
        val heap = PriorityQueue<Int>()
        for ((i, n1, n2) in t) {
            if (n1 > pre)
                preSum = sum

            pre = n1
            rst[i] = preSum

            sum += n2
            heap.add(n2)
            if (heap.size > k)
                sum -= heap.poll()
        }

        return rst
    }
}

fun main() {
    println(Solution3478().findMaxSum(
        intArrayOf(2,2,2,2), intArrayOf(3,1,2,3), 1
    ).toList())
}