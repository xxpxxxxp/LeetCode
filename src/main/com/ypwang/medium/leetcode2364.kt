package com.ypwang.medium

class Solution2364 {
    fun countBadPairs(nums: IntArray): Long =
        nums.size.toLong() * (nums.size - 1) / 2 - nums.withIndex().map { it.value - it.index }.groupBy { it }.map { it.value.size.toLong() }.map { it * (it - 1) /
                2 }
            .sum()
}