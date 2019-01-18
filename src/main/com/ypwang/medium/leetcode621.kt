package com.ypwang.medium

class Solution621 {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val map = tasks.groupBy { it }.map { it.value.size }.sorted()
        val max = map.last() - 1
        var idleSlots = max * n
        for (i in 0 until map.size - 1) {
            idleSlots -= minOf(map[i], max)
        }
        return tasks.size + if (idleSlots > 0) idleSlots else 0
    }
}