package com.ypwang.easy

import java.util.*

class Solution1619 {
    fun trimMean(arr: IntArray): Double {
        val size = arr.size / 20
        val minHeap = PriorityQueue<Int>()
        val maxHeap = PriorityQueue<Int> { o1, o2 -> o2.compareTo(o1) }

        var sum = 0
        for (v in arr) {
            sum += v
            minHeap.offer(v)
            maxHeap.offer(v)

            if (minHeap.size > size)
                minHeap.poll()

            if (maxHeap.size > size)
                maxHeap.poll()
        }

        return (sum.toDouble() - minHeap.sum() - maxHeap.sum()) / (size * 18)
    }
}