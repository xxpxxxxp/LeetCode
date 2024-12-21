package com.ypwang.medium

class Solution3394 {
    private fun mergeIntervals(intervals: MutableList<IntArray>): List<IntArray> {
        if (intervals.size <= 1)
            return intervals

        intervals.sortBy { it[0] }

        val merged = mutableListOf<IntArray>()
        merged.add(intervals[0])

        for (i in 1 until intervals.size) {
            val (cs, ce) = intervals[i]
            val last = merged.last()

            if (cs < last[1])
                last[1] = maxOf(last[1], ce)
            else
                merged.add(intervals[i])
        }

        return merged
    }

    fun checkValidCuts(n: Int, rectangles: Array<IntArray>): Boolean {
        val x = mutableListOf<IntArray>()
        val y = mutableListOf<IntArray>()
        for ((sx, sy, ex, ey) in rectangles) {
            x.add(intArrayOf(sx, ex))
            y.add(intArrayOf(sy, ey))
        }

        return mergeIntervals(x).size >= 3 || mergeIntervals(y).size >= 3
    }
}
