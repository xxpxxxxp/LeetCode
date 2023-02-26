package com.ypwang.easy

class Solution2574 {
    fun leftRigthDifference(nums: IntArray): IntArray {
        var right = nums.sum()
        var left = 0
        for ((i, v) in nums.withIndex()) {
            right -= v
            nums[i] = Math.abs(left - right)
            left += v
        }
        return nums
    }
}