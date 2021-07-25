package com.ypwang.medium

import java.util.*

class Solution1942 {
    fun smallestChair(times: Array<IntArray>, targetFriend: Int): Int {
        var max = 0
        val available = PriorityQueue<Int>()

        // leave time, seat
        val leaves = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })

        for ((idx, arr) in times.withIndex().sortedBy { it.value[0] }) {
            val (arrive, leave) = arr

            while (leaves.isNotEmpty() && leaves.peek().first <= arrive) {
                available.add(leaves.poll().second)
            }

            val seat = if (available.isNotEmpty()) available.poll() else max++

            if (targetFriend == idx)
                return seat

            leaves.offer(leave to seat)
        }

        return -1
    }
}