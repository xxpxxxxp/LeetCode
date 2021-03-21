package com.ypwang.medium

import java.util.*

class Solution1801 {
    fun getNumberOfBacklogOrders(orders: Array<IntArray>): Int {
        val buy = PriorityQueue<IntArray>(compareByDescending { it[0] })
        val sell = PriorityQueue<IntArray>(compareBy { it[0] })

        for (order in orders) {
            when (order[2]) {
                0 -> buy.offer(order)
                1 -> sell.offer(order)
            }

            while (buy.isNotEmpty() && sell.isNotEmpty() && buy.peek()[0] >= sell.peek()[0]) {
                val amount = minOf(buy.peek()[1], sell.peek()[1])
                buy.peek()[1] -= amount
                sell.peek()[1] -= amount

                if (buy.peek()[1] == 0)
                    buy.poll()

                if (sell.peek()[1] == 0)
                    sell.poll()
            }
        }

        return (buy.toList() + sell.toList()).map { it[1] }.reduce { a, b -> (a + b) % 1000000007 }
    }
}