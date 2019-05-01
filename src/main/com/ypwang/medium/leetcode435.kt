package com.ypwang.medium

class Solution435 {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        if (intervals.isEmpty()) return 0

        intervals.sortBy { it[0] }

        var end = intervals[0][1]
        var count = 0
        for (idx in 1 until intervals.size) {
            end = if (end > intervals[idx][0]) {
                count++
                minOf(end, intervals[idx][1])
            } else {
                intervals[idx][1]
            }
        }

        return count
    }
}

fun main() {
    println(Solution435().eraseOverlapIntervals(arrayOf(
            intArrayOf(1,2),intArrayOf(2,3), intArrayOf(3,4), intArrayOf(1,4)
    )))
}