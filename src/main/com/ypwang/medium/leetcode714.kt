package com.ypwang.medium

class Solution714 {
    fun maxProfit(prices: IntArray, fee: Int): Int {
        var cash = 0
        var hold = -prices[0]
        for (i in 1 until prices.size) {
            cash = Math.max(cash, hold + prices[i] - fee)
            hold = Math.max(hold, cash - prices[i])
        }
        return cash
    }
}