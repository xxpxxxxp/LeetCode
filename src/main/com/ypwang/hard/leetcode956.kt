package com.ypwang.hard

class Solution956 {
    fun tallestBillboard(rods: IntArray): Int {
        val dp = mutableMapOf(0 to 0)
        for (x in rods) {
            val cur = dp.toMap()
            for (d in cur.keys) {
                dp[d+x] = maxOf(dp.getOrDefault(d+x, 0), cur[d]!!)
                dp[Math.abs(d-x)] = maxOf(dp.getOrDefault(Math.abs(d-x), 0), cur[d]!! + minOf(d, x))
            }
        }

        return dp[0]!!
    }
}