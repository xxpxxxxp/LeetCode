package com.ypwang.easy

class Solution3683 {
    fun earliestTime(tasks: Array<IntArray>): Int =
        tasks.minOf { it[0] + it[1] }
}
