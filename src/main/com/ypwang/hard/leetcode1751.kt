package com.ypwang.hard

class Solution1751 {
    fun maxValue(events: Array<IntArray>, k: Int): Int {
        events.sortBy { it[1] }

        var dp = mutableListOf(0 to 0)
        for (i in 0 until k) {
            val next = mutableListOf(0 to 0)
            for ((s, e, v) in events) {
                val j = dp.binarySearch { it.first - s }.let { if (it >= 0) it - 1 else -it - 2 }
                if (dp[j].second + v > next.last().second)
                    next.add(e to dp[j].second + v)
            }
            dp = next
        }

        return dp.last().second
    }
}
