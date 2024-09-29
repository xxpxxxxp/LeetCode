package com.ypwang.medium

import java.util.PriorityQueue

class Solution3296 {
    fun minNumberOfSeconds(mountainHeight: Int, workerTimes: IntArray): Long {
        // base, next secs, overall secs
        val heap = PriorityQueue<Triple<Int, Long, Long>>(compareBy { it.second + it.third })
        for (w in workerTimes)
            heap.offer(Triple(w, w.toLong(), 0L))

        for (i in 0 until mountainHeight) {
            val (w, n, o) = heap.poll()
            heap.offer(Triple(w, n + w, n + o))
        }

        return heap.map { it.third }.max()!!
    }
}

fun main() {
    println(Solution3296().minNumberOfSeconds(5, intArrayOf(1, 5)))
}