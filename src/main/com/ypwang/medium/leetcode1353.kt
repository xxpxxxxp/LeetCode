package com.ypwang.medium

import java.util.*

class Solution1353 {
    fun maxEvents(events: Array<IntArray>): Int {
        events.sortWith(compareBy{it[0]})
        val heap = PriorityQueue<Int>()

        var count = 0
        var idx = 0
        for (day in 1..events.map { it[1] }.max()!!) {
            // ended events for today
            while (heap.isNotEmpty() && heap.peek() < day)
                heap.poll()

            // current available events for today
            while (idx < events.size && events[idx][0] == day)
                heap.add(events[idx++][1])

            // found a suitable event
            if (heap.isNotEmpty()) {
                heap.poll()
                count++
            }
        }

        return count
    }
}

fun main() {
    println(Solution1353().maxEvents(arrayOf(
            intArrayOf(1,2),intArrayOf(1,2),intArrayOf(3,3),intArrayOf(1,5),intArrayOf(1,5)
    )))
}