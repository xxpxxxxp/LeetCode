package com.ypwang.medium

class Solution347 {
    fun topKFrequent(nums: IntArray, k: Int): List<Int> {
        return nums.groupBy { it }.map { Pair(it.key, it.value.size) }.sortedBy { it.second }.reversed().take(k).map { it.first }
    }
}