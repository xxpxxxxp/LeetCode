package com.ypwang.medium

class Solution3702 {
    fun longestSubsequence(nums: IntArray): Int {
        val t = nums.reduce { a, b -> a xor b }
        if (t != 0)
            return nums.size

        return if (nums.all { it == 0 }) 0 else nums.size - 1
    }
}
