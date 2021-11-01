package com.ypwang.easy

class Solution2057 {
    fun smallestEqual(nums: IntArray): Int =
        nums.withIndex().firstOrNull { it.index % 10 == it.value }?.index ?: -1
}