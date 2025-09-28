package com.ypwang.medium

class Solution3693 {
    fun climbStairs(n: Int, costs: IntArray): Int {
        val dp = IntArray(n+1)
        for (j in 1..n)
            dp[j] = (maxOf(0, j-3) .. j-1).map {
                dp[it] + costs[j-1] + (j - it) * (j - it)
            }.min()

        return dp.last()
    }
}

fun main() {
    println(Solution3693().climbStairs(4, intArrayOf(1,2,3,4)))
}