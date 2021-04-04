package com.ypwang.medium

class Solution1814 {
    fun countNicePairs(nums: IntArray): Int =
        (nums.map { it - it.toString().reversed().toInt() }
            .groupBy { it }
            .map { it.value.size }
            .map { it.toLong() * (it - 1) / 2 }
            .sum() % 1000000007).toInt()
}