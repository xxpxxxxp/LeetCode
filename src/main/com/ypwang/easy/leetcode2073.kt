package com.ypwang.easy

class Solution2073 {
    fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
        val t = tickets[k]
        return tickets.withIndex().sumBy { (i, v) -> if (i <= k) minOf(v, t) else minOf(v, t-1) }
    }
}