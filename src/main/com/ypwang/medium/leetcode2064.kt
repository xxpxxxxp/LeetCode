package com.ypwang.medium

import java.util.*

class Solution2064 {
    fun minimizedMaximum(n: Int, quantities: IntArray): Int {
        val heap = PriorityQueue<IntArray>(compareByDescending { it[0] })
        for ((i, q) in quantities.withIndex()) {
            heap.add(intArrayOf(q, i, 1))
        }

        for (j in quantities.size until n) {
            val (q, i, c) = heap.poll()
            heap.offer(intArrayOf((quantities[i]+c) / (c+1), i, c+1))
        }

        return heap.peek()[0]
    }
}