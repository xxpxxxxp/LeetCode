package com.ypwang.hard

import java.util.PriorityQueue

class Solution2402 {
    fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
        val ready = PriorityQueue<Int>()
        ready.addAll(0 until n)

        // Pair(end time, room id)
        val occupied = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
        val count = IntArray(n)

        for ((s, e) in meetings.sortedBy { it[0] }) {
            while (occupied.isNotEmpty() && occupied.peek().first <= s)
                ready.offer(occupied.poll().second)

            val (end, r) =
                if (ready.isNotEmpty())
                    e to ready.poll()
                else {
                    val (be, br) = occupied.poll()
                    be + e - s to br
                }

            count[r]++
            occupied.offer(end to r)
        }

        return count.withIndex().maxByOrNull { it.value }!!.index
    }
}