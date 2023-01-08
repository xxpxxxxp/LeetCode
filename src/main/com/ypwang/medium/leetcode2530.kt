package com.ypwang.medium

import java.util.PriorityQueue

class Solution2530 {
    fun maxKelements(nums: IntArray, k: Int): Long {
        val heap = PriorityQueue<Int>(compareByDescending { it })
        nums.forEach { heap.add(it) }

        var rst = 0L
        for (i in 0 until k) {
            val p = heap.poll()
            rst += p
            heap.add((p + 2) / 3)
        }

        return rst
    }
}