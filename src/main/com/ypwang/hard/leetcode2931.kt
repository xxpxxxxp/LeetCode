package com.ypwang.hard

import java.util.PriorityQueue

class Solution2931 {
    fun maxSpending(values: Array<IntArray>): Long {
        val m = values.size
        val n = values[0].size
        val heap = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.first })
        for ((i, arr) in values.withIndex())
            heap.offer(Triple(arr.last(), i, n-1))

        var rst = 0L
        for (d in 1 .. m * n) {
            val (v, i, j) = heap.poll()
            rst += v.toLong() * d
            if (j > 0)
                heap.offer(Triple(values[i][j-1], i, j-1))
        }

        return rst
    }
}