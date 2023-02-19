package com.ypwang.medium

class Solution2567 {
    fun minimizeSum(nums: IntArray): Int {
        nums.sort()
        return minOf(nums.last() - nums[2], nums[nums.lastIndex-2] - nums[0], nums[nums.lastIndex-1] - nums[1])
    }
}