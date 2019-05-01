package com.ypwang.medium

class Solution309 {
    fun maxProfit(prices: IntArray): Int {
        var sell = 0
        var prev_sell = 0
        var buy = Integer.MIN_VALUE
        var prev_buy = 0
        for (price in prices) {
            prev_buy = buy
            buy = maxOf(prev_sell - price, prev_buy)
            prev_sell = sell
            sell = maxOf(prev_buy + price, prev_sell)
        }
        return sell
    }
}