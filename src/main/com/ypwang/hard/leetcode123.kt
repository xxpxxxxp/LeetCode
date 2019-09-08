package com.ypwang.hard

class Solution123 {
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) return 0

        val dp = IntArray(prices.size)

        var minPrice = Int.MAX_VALUE
        var maxProfile = 0

        for ((i, p) in prices.withIndex()) {
            maxProfile = maxOf(maxProfile, p - minPrice)
            minPrice = minOf(minPrice, p)

            dp[i] = maxProfile
        }

        var maxPrice = prices.last()
        for (i in prices.lastIndex-1 downTo 1) {
            maxProfile = maxOf(maxProfile, maxPrice - prices[i] + dp[i-1])
            maxPrice = maxOf(maxPrice, prices[i])
        }

        return maxProfile
    }
}

fun main() {
    println(Solution123().maxProfit(intArrayOf(3,3,5,0,0,3,1,4)))
    println(Solution123().maxProfit(intArrayOf(1,2,3,4,5)))
    println(Solution123().maxProfit(intArrayOf(7,6,4,3,1)))
}