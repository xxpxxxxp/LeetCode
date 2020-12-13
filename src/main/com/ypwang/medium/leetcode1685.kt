package com.ypwang.medium

class Solution1685 {
    fun getSumAbsoluteDifferences(nums: IntArray): IntArray {
        val rst = IntArray(nums.size)
        rst[0] = nums.sum() - nums[0] * nums.size

        for (i in 1 until rst.size) {
            rst[i] = rst[i-1] + (nums[i] - nums[i-1]) * (2 * i - nums.size)
        }

        return rst
    }
}