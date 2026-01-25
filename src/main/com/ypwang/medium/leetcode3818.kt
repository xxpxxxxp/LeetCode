package com.ypwang.medium

class Solution3818 {
    fun minimumPrefixLength(nums: IntArray): Int {
        var j = nums.lastIndex - 1
        while (j >= 0 && nums[j] < nums[j+1])
            j--

        return j+1
    }
}
