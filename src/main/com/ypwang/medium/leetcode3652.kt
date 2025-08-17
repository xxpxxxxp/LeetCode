package com.ypwang.medium

class Solution3652 {
    fun maxProfit(prices: IntArray, strategy: IntArray, k: Int): Long {
        val n = prices.size
        val h = k / 2
        val sp = LongArray(n)
        var initial_profit = 0L
        for (i in 0 until n) {
            sp[i] = strategy[i].toLong() * prices[i]
            initial_profit += sp[i]
        }

        if (n == k) {
            val original_profit_in_window = initial_profit
            var new_profit_from_modification = 0L
            for (i in h until n)
                new_profit_from_modification += prices[i].toLong()
            val change = new_profit_from_modification - original_profit_in_window
            val increase = maxOf(0, change)
            return initial_profit + increase
        }

        var original_profit_in_window = 0L
        for (i in 0 until k)
            original_profit_in_window += sp[i]

        var new_profit_from_modification = 0L
        for (i in h until k)
            new_profit_from_modification += prices[i].toLong()

        var current_change = new_profit_from_modification - original_profit_in_window
        var max_change = current_change

        for (i in 1..n - k) {
            original_profit_in_window += sp[i + k - 1] - sp[i - 1]
            new_profit_from_modification += (prices[i + k - 1] - prices[i - 1 + h]).toLong()
            current_change = new_profit_from_modification - original_profit_in_window
            if (current_change > max_change)
                max_change = current_change
        }

        return initial_profit + maxOf(0, max_change)
    }
}
