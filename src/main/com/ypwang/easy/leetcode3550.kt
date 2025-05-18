package com.ypwang.easy

class Solution3550 {
    fun smallestIndex(nums: IntArray): Int =
        nums.withIndex().firstOrNull { it.index == it.value.toString().map { i -> i - '0' }.sum() }?.index ?: -1
}
