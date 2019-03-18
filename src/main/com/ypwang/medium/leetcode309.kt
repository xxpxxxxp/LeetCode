package com.ypwang.medium

class Solution309 {
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty())
            return 0

        var s0 = 0                      // max profile made without stock on hand
        var s1 = -prices[0]         // max profile made with stock on hand
        var s2 = Int.MIN_VALUE      // max profile made after sell last stock

        for (i in 1 until prices.size) {
            val (s0c, s1c, s2c) = Triple(s0, s1, s2)

            s0 = maxOf(s0c, s2c)         // don't by stock, or sell last stock
            s1 = maxOf(s1c, s0c - prices[i])
            s2 = s1c + prices[i]
        }

        return maxOf(s0, s2)
    }
}