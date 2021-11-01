package com.ypwang.medium

class Solution2054 {
    fun maxTwoEvents(events: Array<IntArray>): Int {
        val se = events.sortedBy { it[1] }

        var j = 0
        var max = 0
        var rst = Int.MIN_VALUE

        for ((s, e, v) in events.sortedBy { it[0] }) {
            while (se[j][1] < s) {
                max = maxOf(max, se[j++][2])
            }

            rst = maxOf(rst, max + v)
        }

        return rst
    }
}