package com.ypwang.easy

class Solution3194 {
    fun minimumAverage(nums: IntArray): Double {
        nums.sort()
        return (0 until nums.size/2).map {
            (nums[it] + nums[nums.size-1-it]) / 2.0
        }.min()!!
    }
}
