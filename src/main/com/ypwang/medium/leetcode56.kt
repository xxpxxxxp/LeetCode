package com.ypwang.medium

class Solution56 {
    fun merge(intervals: List<Interval>): List<Interval> {
        if (intervals.isEmpty()) {
            return intervals
        }

        val ins = intervals.sortedBy { it.start }
        val rst = mutableListOf<Interval>()
        var cur: Interval = ins.first()
        for (i in ins) {
            cur = if (i.start <= cur.end) {
                Interval(cur.start, Math.max(cur.end, i.end))
            } else {
                rst.add(cur)
                i
            }
        }
        rst.add(cur)

        return rst
    }
}

fun main() {
    println(Solution56().merge(listOf(
            Interval(1,3),Interval(2,6),Interval(8,10),Interval(15,18)
    )))
}