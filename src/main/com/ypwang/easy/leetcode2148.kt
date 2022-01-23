package com.ypwang.easy

class Solution2148 {
    fun countElements(nums: IntArray): Int =
        nums.groupBy { it }
            .mapValues { it.value.size }
            .toList()
            .sortedBy { it.first }
            .drop(1)
            .dropLast(1)
            .map { it.second }
            .sum()!!
}