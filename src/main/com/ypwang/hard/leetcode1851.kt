package com.ypwang.hard

import java.util.*

class Solution1851 {
    fun minInterval(intervals: Array<IntArray>, queries: IntArray): IntArray {
        intervals.sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] })

        val heap = PriorityQueue(compareBy<IntArray> { it[1] - it[0] })
        val ans = IntArray(queries.size)
        var idx = 0
        for ((i, q) in queries.withIndex().sortedBy { it.value }) {
            while (idx < intervals.size && intervals[idx][0] <= q) {
                heap.add(intervals[idx])
                idx++
            }

            while (heap.isNotEmpty() && heap.peek()[1] < q)
                heap.poll()

            ans[i] = if (heap.isEmpty()) -1 else heap.peek().let { it[1] - it[0] + 1 }
        }

        return ans
    }
}

fun main() {
    println(Solution1851().minInterval(
        arrayOf(intArrayOf(4,5),intArrayOf(5,8),intArrayOf(1,9),intArrayOf(8,10),intArrayOf(1,6)), intArrayOf(7,9,3,9,3)
    ).toList())
}