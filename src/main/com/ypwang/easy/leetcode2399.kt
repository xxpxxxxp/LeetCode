package com.ypwang.easy

class Solution2399 {
    fun checkDistances(s: String, distance: IntArray): Boolean =
        s.withIndex().groupBy { it.value }.mapValues {
            val (a, b) = it.value
            b.index - a.index - 1
        }.all { distance[it.key - 'a'] == it.value }
}