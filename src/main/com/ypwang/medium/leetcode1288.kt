package com.ypwang.medium

class Solution1288 {
    fun removeCoveredIntervals(intervals: Array<IntArray>): Int =
        intervals.sortedWith(Comparator { a, b ->
            if (a[0] != b[0]) a[0] - b[0]
            else b[1] - a[1]
        }).fold(Int.MIN_VALUE to 0) { (end, count), (_, b) ->
            if (b > end) b to count + 1 else end to count
        }.second
}

fun main() {
    println(Solution1288().removeCoveredIntervals(arrayOf(
            intArrayOf(1,4), intArrayOf(3,6), intArrayOf(2,8)
    )))
}