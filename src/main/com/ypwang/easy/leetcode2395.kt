package com.ypwang.easy

class Solution2395 {
    fun findSubarrays(nums: IntArray): Boolean =
        (1 until nums.size).map { nums[it-1] + nums[it] }.toSet().size < nums.size - 1
}