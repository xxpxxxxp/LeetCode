package com.ypwang.hard

class Solution4068 {
    fun maxEarnings(meetings: Array<IntArray>): Long {
        val n = meetings.size

        // Sort by start time, then end time, then revenue
        meetings.sortWith(compareBy<IntArray> { it[0] }
            .thenBy { it[1] }
            .thenBy { it[2] })

        // Indices sorted by meeting end time
        val ends = Array(n) { it }
        ends.sortWith(compareBy { meetings[it][1] })

        val dp = LongArray(n)

        var bst = Long.MIN_VALUE
        var temp = 0

        for (i in 0 until n) {
            val start = meetings[i][0].toLong()
            val revenue = meetings[i][2].toLong()

            while (temp < n && meetings[ends[temp]][1].toLong() <= start) {
                val k = ends[temp]
                bst = maxOf(bst, dp[k] - meetings[k][1].toLong())
                temp++
            }

            dp[i] = revenue

            if (bst != Long.MIN_VALUE) {
                dp[i] = maxOf(
                    dp[i],
                    revenue + start + bst
                )
            }
        }

        return dp.max()
    }
}
