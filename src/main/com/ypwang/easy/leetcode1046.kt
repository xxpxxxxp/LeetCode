package com.ypwang.easy

import java.util.*

class Solution1046 {
    fun lastStoneWeight(stones: IntArray): Int {
        val heap = PriorityQueue<Int>(kotlin.Comparator { o1, o2 -> o2 - o1 })
        heap.addAll(stones.toList())

        while (heap.size > 1) {
            val max = heap.poll()
            val n = heap.poll()

            if (max != n) heap.add(max - n)
        }

        return if (heap.isEmpty()) 0 else heap.single()
    }
}