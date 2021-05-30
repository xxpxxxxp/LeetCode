package com.ypwang.medium

class Solution1877 {
    fun minPairSum(nums: IntArray): Int {
        nums.sort()
        return (0 until nums.size / 2).map { nums[it] + nums[nums.lastIndex-it] }.max()!!
    }
}