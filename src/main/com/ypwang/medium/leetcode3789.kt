package com.ypwang.medium

class Solution3789 {
    fun minimumCost(cost1: Int, cost2: Int, costBoth: Int, need1: Int, need2: Int): Long {
        var ans = Long.MAX_VALUE
        ans = minOf(ans, need1.toLong() * cost1 + need2.toLong() * cost2)

        val min = minOf(need1, need2).toLong()
        ans = minOf(ans, min * costBoth + (need1 - min) * cost1 + (need2 - min) * cost2)

        val max = maxOf(need1, need2).toLong()
        ans = minOf(ans, max * costBoth)

        return ans
    }
}
