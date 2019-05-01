package com.ypwang.medium

class Solution376 {
    fun wiggleMaxLength(nums: IntArray): Int {
        if (nums.size < 2) return nums.size
        var pre = nums[1] - nums[0]
        var count = if (pre != 0) 2 else 1

        for (i in 1 until nums.lastIndex) {
            val diff = nums[i+1] - nums[i]
            if ((diff > 0 && pre <= 0) || (diff < 0 && pre >= 0)) {
                pre = diff
                count++
            }
        }

        return count
    }
}