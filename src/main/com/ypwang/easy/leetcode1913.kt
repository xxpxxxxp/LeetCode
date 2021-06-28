package com.ypwang.easy

import java.util.*

class Solution1913 {
    fun maxProductDifference(nums: IntArray): Int {
        val minHeap = PriorityQueue<Int>(compareByDescending { it })
        val maxHeap = PriorityQueue<Int>()

        for (v in nums) {
            if (minHeap.size == 2 && v < minHeap.peek())
                minHeap.poll()

            if (minHeap.size < 2)
                minHeap.add(v)

            if (maxHeap.size == 2 && v > maxHeap.peek())
                maxHeap.poll()

            if (maxHeap.size < 2)
                maxHeap.add(v)
        }

        return maxHeap.reduce { a, b -> a * b } - minHeap.reduce { a, b -> a * b }
    }
}

fun main() {
    println(Solution1913().maxProductDifference(intArrayOf(5,6,2,7,4)))
}