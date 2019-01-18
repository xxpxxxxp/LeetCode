package com.ypwang.medium

data class Interval(var start: Int = 0, var end: Int = 0)

class Solution436 {
    fun findRightInterval(intervals: Array<Interval>): IntArray {
        val sortedLeft = intervals.map { it.start }.withIndex().sortedBy { it.value }
        val values = sortedLeft.map { it.value }
        val index = sortedLeft.map { it.index }

        return intervals.map {
            var p = values.binarySearch(it.end)
            if (p < 0) {
                p = -(p + 1)
                if (p > values.lastIndex) {
                    -1
                } else {
                    index[p]
                }
            }
            else {
                index[p]
            }
        }.toIntArray()
    }
}

fun main(args: Array<String>) {
    println(Solution436().findRightInterval(arrayOf(
            Interval(3, 4), Interval(2, 3), Interval(1, 2)
    )).toList())
    println(Solution436().findRightInterval(arrayOf(
            Interval(1, 4), Interval(2, 3), Interval(3, 4)
    )).toList())
}