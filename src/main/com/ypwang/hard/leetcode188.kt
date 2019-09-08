package com.ypwang.hard

class Solution188 {
    fun maxProfit(k: Int, prices: IntArray): Int {
        if (k >= prices.size / 2) {
            return (1 until prices.size).map { prices[it] - prices[it-1] }.filter { it > 0 }.sum()
        }

        val dp = Array(k+1){ IntArray(prices.size) }
        for (i in 1..k) {
            var max = -prices[0]
            for (j in 1 until prices.size) {
                dp[i][j] = maxOf(dp[i][j-1], prices[j] + max)
                max = maxOf(max, dp[i-1][j] - prices[j])
            }
        }

        return dp.last().last()
    }
}

fun main() {
    println(Solution188().maxProfit(2, intArrayOf(2,4,1)))
    println(Solution188().maxProfit(2, intArrayOf(3,2,6,5,0,3)))
}