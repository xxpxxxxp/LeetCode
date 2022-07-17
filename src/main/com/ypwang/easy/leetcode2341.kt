package com.ypwang.easy

class Solution2341 {
    fun numberOfPairs(nums: IntArray): IntArray {
        val c = nums.groupBy { it }.map { it.value.size }
        return intArrayOf(c.map { it / 2 }.sum(), c.map { it % 2 }.sum())
    }
}