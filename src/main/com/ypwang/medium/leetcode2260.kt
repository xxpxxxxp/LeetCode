package com.ypwang.medium

class Solution2260 {
    fun minimumCardPickup(cards: IntArray): Int =
        cards
            .withIndex()
            .groupBy { it.value }
            .map { it.value.map { kv -> kv.index } }
            .filter { it.size > 1 }
            .map { (1 until it.size).map { i -> it[i] - it[i-1] + 1 }.minOrNull()!! }
            .minOrNull() ?: -1
}