package com.ypwang.medium

class Solution3169 {
    fun countDays(days: Int, meetings: Array<IntArray>): Int {
        meetings.sortBy { it[0] }
        var rst = days

        var start = meetings[0][0]
        var end = meetings[0][1]

        for (i in 1 until meetings.size) {
            val (s, e) = meetings[i]
            if (s <= end)
                end = maxOf(end, e)
            else {
                rst -= 1 + end - start
                start = s
                end = e
            }
        }

        return rst + 1 + end - start
    }
}
