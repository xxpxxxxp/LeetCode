package com.ypwang.medium

class Solution3951 {
    fun minEnergy(n: Int, brightness: Int, intervals: Array<IntArray>): Long {
        intervals.sortBy { it[0] }

        var at = 0L
        var st = intervals[0][0].toLong()
        var end = intervals[0][1].toLong()

        for (x in intervals.indices) {
            if (intervals[x][0].toLong() <= end) {
                end = maxOf(end, intervals[x][1].toLong())
            } else {
                at += end - st + 1
                st = intervals[x][0].toLong()
                end = intervals[x][1].toLong()
            }
        }

        at += end - st + 1

        val need = (brightness + 2L) / 3L
        return need * at
    }
}
