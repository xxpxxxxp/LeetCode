package com.ypwang.medium

class Solution1227 {
    // math
    /* use dp:
        dp[0] = 0.0
        dp[1] = 1.0
        dp[n] = (dp[0] + dp[1] + ... + dp[n-1]) / n
        rst = dp[n] (could be proved that dp[1] = 1.0 and all others = 0.5)
     */
    fun nthPersonGetsNthSeat(n: Int): Double = if (n == 1) 1.0 else 0.5
}