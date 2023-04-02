package com.ypwang.medium

class Solution2611 {
    fun miceAndCheese(reward1: IntArray, reward2: IntArray, k: Int): Int {
        val idx = reward1.zip(reward2)
            .map { it.first - it.second }
            .withIndex()
            .sortedByDescending { it.value }
            .take(k)
            .map { it.index }
            .toSet()

        return reward1.withIndex().filter { it.index in idx }.map { it.value }.sum() +
               reward2.withIndex().filter { it.index !in idx }.map { it.value }.sum()
    }
}
