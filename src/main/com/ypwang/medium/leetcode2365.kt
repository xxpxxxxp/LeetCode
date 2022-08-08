package com.ypwang.medium

class Solution2365 {
    fun taskSchedulerII(tasks: IntArray, space: Int): Long {
        var ds = 0L
        val seen = mutableMapOf<Int, Long>()

        for (t in tasks) {
            val s = seen.getOrDefault(t, Long.MIN_VALUE)
            val d = maxOf(++ds, s + space + 1)
            seen[t] = d
            ds = d
        }

        return ds
    }
}

fun main() {
    println(Solution2365().taskSchedulerII(intArrayOf(1,2,1,2,3,1), 3))
    println(Solution2365().taskSchedulerII(intArrayOf(5,8,8,5), 2))
}