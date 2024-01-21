package com.ypwang.easy

class Solution3010 {
    fun minimumCost(nums: IntArray): Int {
        var min1 = Int.MAX_VALUE
        var min2 = Int.MAX_VALUE

        for (i in 1 until nums.size) {
            if (nums[i] < min1) {
                min2 = min1
                min1 = nums[i]
            } else if (nums[i] < min2)
                min2 = nums[i]
        }

        return nums[0] + min1 + min2
    }
}
