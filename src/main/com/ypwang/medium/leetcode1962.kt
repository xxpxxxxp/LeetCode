package com.ypwang.medium

import java.util.*

class Solution1962 {
    fun minStoneSum(piles: IntArray, k: Int): Int {
        val heap = PriorityQueue<Int>(compareByDescending { it })
        heap.addAll(piles.toList())

        repeat(k) {
            heap.offer((heap.poll() + 1) / 2)
        }

        return heap.sum()
    }
}