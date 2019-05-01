package com.ypwang.medium

class Solution518 {
    fun change(amount: Int, coins: IntArray): Int {
        if (amount == 0) return 1
        if (coins.isEmpty()) return 0

        coins.sort()
        val dp = IntArray(amount + 1){0}
        dp[0] = 1

        for (i in 1..(amount/coins[0]))
            dp[i * coins[0]] = 1

        for (i in 1 until coins.size) {
            for (a in 1..amount) {
                if (a - coins[i] >= 0) dp[a] += dp[a - coins[i]]
            }
        }

        return dp.last()
    }
}

fun main() {
    println(Solution518().change(5, intArrayOf(1,2,5)))
}