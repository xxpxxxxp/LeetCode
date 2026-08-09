package com.ypwang.medium

class Solution4014 {
    fun minPrice(prices: IntArray, discounts: IntArray): Double {
        prices.sortDescending()
        discounts.sortDescending()

        return (prices.indices).map {
            if (it in discounts.indices)
                prices[it] * (100 - discounts[it]) / 100.0
            else
                prices[it].toDouble()
        }.sum()
    }
}
