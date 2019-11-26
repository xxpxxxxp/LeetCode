package com.ypwang.hard

import java.util.*

class Solution480 {
    fun medianSlidingWindow(nums: IntArray, k: Int): DoubleArray {
        val minHeap = PriorityQueue<Int>()
        val maxHeap = PriorityQueue<Int>(Collections.reverseOrder())

        val n = nums.size - k + 1
        if (n <= 0) return doubleArrayOf()
        val rst = DoubleArray(n)

        fun median(): Double {
            if (minHeap.isEmpty() && maxHeap.isEmpty()) return 0.0
            return if (minHeap.size == maxHeap.size) (minHeap.peek().toDouble() + maxHeap.peek().toDouble()) / 2
            else minHeap.peek().toDouble()
        }

        // minHeap.size = maxHeap.size + [0, 1]
        fun balance() {
            if (maxHeap.size > minHeap.size) minHeap.add(maxHeap.poll())
            if (minHeap.size > maxHeap.size + 1) maxHeap.add(minHeap.poll())
        }

        for (i in 0..nums.size) {
            if (i >= k) {
                rst[i-k] = median()
                val cur = nums[i-k]
                if (cur < rst[i-k]) maxHeap.remove(cur) else minHeap.remove(cur)
                balance()
            }

            if (i < nums.size) {
                if (nums[i] < median()) maxHeap.offer(nums[i])
                else minHeap.offer(nums[i])
                balance()
            }
        }

        return rst
    }
}

fun main() {
    println(Solution480().medianSlidingWindow(intArrayOf(-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648), 3).toList())
}