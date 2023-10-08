package com.ypwang.medium

class Solution2895 {
    fun minProcessingTime(processorTime: List<Int>, tasks: List<Int>): Int {
        val ts = tasks.sortedDescending()
        return processorTime.sorted().withIndex().map { (i, v) ->
            listOf(ts[i * 4], ts[i * 4 + 1], ts[i * 4 + 2], ts[i * 4 + 3]).max()!! + v
        }.max()!!
    }
}