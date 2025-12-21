package com.ypwang.medium

class Solution3784 {
    fun minCost(s: String, cost: IntArray): Long =
        cost.fold(0L) { a, b -> a + b } -
        cost.zip(s.toList())
            .groupBy { it.second }
            .map { it.value.fold(0L) { a, b -> a + b.first } }
            .max()
}
