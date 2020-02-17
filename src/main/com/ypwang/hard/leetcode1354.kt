package com.ypwang.hard

import java.util.*

class Solution1354 {
    fun isPossible(target: IntArray): Boolean {
        var sum = target.fold(0L){ sum, v -> sum + v }
        val heap = PriorityQueue<IndexedValue<Int>>(compareByDescending { it.value })
        heap.addAll(target.withIndex())

        while (true) {
            val t = heap.poll()
            if (t.value == 1) return true
            val otherSum = sum - t.value
            if (t.value <= otherSum) return false
            heap.add(IndexedValue(t.index, (t.value - otherSum).toInt()))
            sum -= otherSum
        }
    }
}