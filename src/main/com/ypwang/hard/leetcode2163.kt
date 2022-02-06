package com.ypwang.hard

import java.util.*

class Solution2163 {
    fun minimumDifference(nums: IntArray): Long {
        val n = nums.size / 3

        val lHeap = PriorityQueue<Int>(compareByDescending { it })
        var lSum = 0L
        for (i in 0 until n) {
            lHeap.add(nums[i])
            lSum += nums[i]
        }

        val left = LongArray(n+1)
        left[0] = lSum
        for (i in 0 until n) {
            lHeap.add(nums[i+n])
            lSum += nums[i+n]
            lSum -= lHeap.poll()
            left[i+1] = lSum
        }

        val rHeap = PriorityQueue<Int>()
        var rSum = 0L
        for (i in 0 until n) {
            rHeap.add(nums[nums.lastIndex - i])
            rSum += nums[nums.lastIndex - i]
        }

        val right = LongArray(n+1)
        right[0] = rSum
        for (i in 0 until n) {
            rHeap.add(nums[2*n - 1 - i])
            rSum += nums[2*n - 1 - i]
            rSum -= rHeap.poll()
            right[i+1] = rSum
        }

        return left.zip(right.reversed()).map { it.first - it.second }.minOrNull()!!
    }
}

fun main() {
    println(Solution2163().minimumDifference(intArrayOf(7,9,5,8,1,3)))
    println(Solution2163().minimumDifference(intArrayOf(3,1,2)))
}