package com.ypwang.medium

class Solution983 {
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        val cost = IntArray(days.last() + 1){0}
        var lastVal = 0
        var lastDay = 0

        for (day in days) {
            for (i in lastDay + 1 until day) {
                cost[i] = lastVal
            }

            cost[day] = minOf(
                    cost[day-1] + costs[0],
                    (if (day >= 7) cost[day-7] else 0) + costs[1],
                    (if (day >= 30) cost[day-30] else 0) + costs[2]
            )

            lastVal = cost[day]
            lastDay = day
        }

        return cost.last()
    }
}

fun main() {
    println(Solution983().mincostTickets(intArrayOf(1,4,6,7,8,20), intArrayOf(7,2,15)))
}