package com.ypwang.medium

class Solution2740 {
    fun findValueOfPartition(nums: IntArray): Int {
        nums.sort()
        return (1 until nums.size).map { nums[it] - nums[it - 1] }.min()!!
    }
}