package com.ypwang.easy

class Solution3386 {
    fun buttonWithLongestTime(events: Array<IntArray>): Int {
        val map = mutableMapOf<Int, Int>()
        var p = 0

        for ((i, v) in events) {
            map[i] = maxOf(map.getOrDefault(i, 0), v - p)
            p = v
        }

        return map.toList().maxWith(compareBy<Pair<Int, Int>> { it.second }.thenByDescending { it.first }).first
    }
}
