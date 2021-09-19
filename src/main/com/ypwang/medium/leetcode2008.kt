package com.ypwang.medium

class Solution2008 {
    fun maxTaxiEarnings(n: Int, rides: Array<IntArray>): Long {
        val dp = LongArray(n+1)
        val start = rides.groupBy { it[0] }

        for (i in 1..n) {
            dp[i] = maxOf(dp[i-1], dp[i])

            if (i in start) {
                for ((s, e, t) in start[i]!!) {
                    dp[e] = maxOf(dp[e], dp[i] + t + e - s)
                }
            }
        }

        return dp.last()
    }
}

fun main() {
    println(Solution2008().maxTaxiEarnings(5, arrayOf(
        intArrayOf(2,5,4), intArrayOf(1,5,1)
    )))
    println(Solution2008().maxTaxiEarnings(20, arrayOf(
        intArrayOf(1,6,1),intArrayOf(3,10,2),intArrayOf(10,12,3),intArrayOf(11,12,2),intArrayOf(12,15,2),intArrayOf(13,18,1)
    )))
}