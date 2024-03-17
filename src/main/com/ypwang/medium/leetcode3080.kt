package com.ypwang.medium

import java.util.PriorityQueue

class Solution3080 {
    fun unmarkedSumArray(nums: IntArray, queries: Array<IntArray>): LongArray {
        val heap = PriorityQueue(compareBy<IndexedValue<Int>> { it.value }.thenBy { it.index })
        heap.addAll(nums.withIndex())
        var sum = nums.fold(0L) { a, b -> a + b }

        val rst = LongArray(queries.size)
        for ((i, arr) in queries.withIndex()) {
            val (j, k) = arr

            if (heap.remove(IndexedValue(j, nums[j])))
                sum -= nums[j]

            for (z in 0 until k) {
                if (heap.isEmpty())
                    break

                sum -= heap.poll().value
            }

            rst[i] = sum
        }

        return rst
    }
}
