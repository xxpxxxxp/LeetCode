package com.ypwang.easy

import java.util.PriorityQueue

class Solution3264 {
    fun getFinalState(nums: IntArray, k: Int, multiplier: Int): IntArray {
        val heap = PriorityQueue(compareBy<IndexedValue<Int>> { it.value }.thenBy { it.index })
        heap.addAll(nums.withIndex())

        for (i in 0 until k) {
            val (i, v) = heap.poll()
            heap.offer(IndexedValue(i, v * multiplier))
        }

        for ((i, v) in heap)
            nums[i] = v

        return nums
    }
}
