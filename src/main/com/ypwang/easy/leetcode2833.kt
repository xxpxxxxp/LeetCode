package com.ypwang.easy

class Solution2833 {
    fun furthestDistanceFromOrigin(moves: String): Int {
        val counts = moves.groupBy { it }.mapValues { it.value.size }
        val l = counts.getOrDefault('L', 0)
        val r = counts.getOrDefault('R',  0)
        val blank = counts.getOrDefault('_', 0)
        return maxOf(l, r) - minOf(l, r) + blank
    }
}