package com.ypwang.easy

class Solution3392 {
    fun countSubarrays(nums: IntArray): Int =
        (2 until nums.size).count {
            2 * (nums[it-2] + nums[it]) == nums[it-1]
        }
}
