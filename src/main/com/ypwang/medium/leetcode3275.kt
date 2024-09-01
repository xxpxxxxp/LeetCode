package com.ypwang.medium

import java.util.PriorityQueue

class Solution3275 {
    fun resultsArray(queries: Array<IntArray>, k: Int): IntArray {
        val pq = PriorityQueue<Int>(compareByDescending { it })
        val rst = IntArray(queries.size)

        for ((i, q) in queries.withIndex()) {
            val distance = Math.abs(q[0]) + Math.abs(q[1])
            pq.add(distance)

            if (pq.size > k)
                pq.poll()

            rst[i] = if (pq.size < k) -1 else pq.peek()
        }

        return rst
    }
}
