package com.ypwang.hard

import java.util.*

class MedianFinder {
    /** initialize your data structure here. */
    private val maxHeap = PriorityQueue<Int>(Collections.reverseOrder())
    private val minHeap = PriorityQueue<Int>()

    // minHeap.size = maxHeap.size + [0, 1]
    fun addNum(num: Int) {
        val mid = findMedian()
        if (num < mid) maxHeap.offer(num) else minHeap.offer(num)
        if (maxHeap.size > minHeap.size) minHeap.offer(maxHeap.poll())
        if (minHeap.size - maxHeap.size > 1) maxHeap.offer(minHeap.poll())
    }

    fun findMedian(): Double {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) return 0.0
        if (maxHeap.size < minHeap.size) return minHeap.peek().toDouble()
        return (maxHeap.peek() + minHeap.peek()) / 2.0
    }
}

fun main() {
    val m = MedianFinder()
    m.addNum(1)
    m.addNum(2)
    println(m.findMedian())
    m.addNum(3)
    println(m.findMedian())
}