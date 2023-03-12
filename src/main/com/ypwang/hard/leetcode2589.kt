package com.ypwang.hard

class Solution2589 {
    fun findMinimumTime(tasks: Array<IntArray>): Int {
        val line = BooleanArray(2001)
        tasks.sortBy { it[1] }
        for ((st, end, d) in tasks) {
            var c = d - (st..end).count { line[it] }
            var i = end
            while (c > 0) {
                if (!line[i])
                    c--
                line[i--] = true
            }
        }
        return line.count { it }
    }
}

fun main() {
    println(Solution2589().findMinimumTime(arrayOf(
        intArrayOf(2,3,1), intArrayOf(4,5,1), intArrayOf(1,5,2)
    )))
}