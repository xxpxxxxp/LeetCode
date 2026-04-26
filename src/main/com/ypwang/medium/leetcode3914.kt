package com.ypwang.medium

class Solution3914 {
    fun minOperations(nums: IntArray): Long {
        var rst = 0L
        for (i in 1 until nums.size) {
            if (nums[i-1] > nums[i])
                rst += nums[i-1] - nums[i]
        }

        return rst
    }
}
