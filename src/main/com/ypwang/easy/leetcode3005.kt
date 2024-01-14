package com.ypwang.easy

class Solution3005 {
    fun maxFrequencyElements(nums: IntArray): Int {
        val c = nums.groupBy { it }.mapValues { it.value.size }
        val m = c.values.max()!!
        return c.filter { it.value == m }.map { it.value }.sum()!!
    }
}