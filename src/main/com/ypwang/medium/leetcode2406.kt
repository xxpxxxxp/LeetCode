package com.ypwang.medium

import java.util.*

class Solution2406 {
    fun minGroups(intervals: Array<IntArray>): Int {
        intervals.sortBy { it[0] }
        val minHeap = PriorityQueue<Int>()
        for ((s, e) in intervals) {
            if (minHeap.isNotEmpty() && minHeap.peek() < s)
                minHeap.remove()
            minHeap.offer(e)
        }
        return minHeap.size
    }
}