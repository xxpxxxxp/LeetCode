package com.ypwang.easy

class Solution2706 {
    fun buyChoco(prices: IntArray, money: Int): Int {
        prices.sort()
        val s = prices.take(2).sum()!!
        if (s <= money)
            return money - s
        return money
    }
}