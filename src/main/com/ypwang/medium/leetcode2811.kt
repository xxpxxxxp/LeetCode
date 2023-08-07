package com.ypwang.medium

class Solution2811 {
    fun canSplitArray(nums: List<Int>, m: Int): Boolean {
        if (nums.size <= 2)
            return true

        for (i in 1 until nums.size)
            if (nums[i-1] + nums[i] >= m)
                return true
        return false
    }
}