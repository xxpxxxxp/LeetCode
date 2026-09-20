package com.ypwang.medium

class Solution4057 {
    fun countIntersectingIntervals(intervals: Array<IntArray>): Long {
        val n = intervals.size

        val s = IntArray(n) { intervals[it][0] }
        val e = IntArray(n) { intervals[it][1] }

        s.sort()
        e.sort()

        var res = 0L
        var j = 0

        for (i in 0 until n) {
            while (j < n && e[j] < s[i])
                j++

            res += (i - j).toLong()
        }

        return res
    }
}
