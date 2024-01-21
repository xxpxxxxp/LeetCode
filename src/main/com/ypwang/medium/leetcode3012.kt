package com.ypwang.medium

class Solution3012 {
    fun minimumArrayLength(nums: IntArray): Int {
        val min = nums.min()!!
        return if (nums.any { it % min != 0 }) 1 else (nums.count { it == min } + 1) / 2
    }
}
