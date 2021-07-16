package com.ypwang.hard

import java.util.*

class Solution1928 {
    fun minCost(maxTime: Int, edges: Array<IntArray>, passingFees: IntArray): Int {
        val connection = mutableMapOf<Int, MutableList<IntArray>>()
        for ((x, y, time) in edges) {
            connection.getOrPut(x) { mutableListOf() }.add(intArrayOf(passingFees[y], time, y))
            connection.getOrPut(y) { mutableListOf() }.add(intArrayOf(passingFees[x], time, x))
        }

        val cost = IntArray(passingFees.size) { Int.MAX_VALUE }
        cost[0] = passingFees[0]
        val time = IntArray(passingFees.size) { Int.MAX_VALUE }
        time[0] = 0

        val heap = PriorityQueue(compareBy<IntArray> { it[0] }.thenBy { it[1] })
        heap.offer(intArrayOf(cost[0], time[0], 0))

        while (heap.isNotEmpty()) {
            val (xf, xt, x) = heap.poll()

            if (x == passingFees.lastIndex)
                return xf

            for ((yf, yt, y) in connection.getOrDefault(x, mutableListOf())) {
                // if this edge does not cause the time to exceed maxTime
                if (xt + yt <= maxTime) {
                    // if cost or time will decrease
                    if (cost[y] > xf + yf || time[y] > xt + yt) {
                        cost[y] = xf + yf
                        time[y] = xt + yt
                        heap.offer(intArrayOf(cost[y], time[y], y))
                    }
                }
            }
        }

        return -1
    }
}

fun main() {
    println(Solution1928().minCost(30, arrayOf(
        intArrayOf(0,1,10),intArrayOf(1,2,10),intArrayOf(2,5,10),intArrayOf(0,3,1),intArrayOf(3,4,10),intArrayOf(4,5,15)
    ), intArrayOf(5,1,2,20,20,3)))
}