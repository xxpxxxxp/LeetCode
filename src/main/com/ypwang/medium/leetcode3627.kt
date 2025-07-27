package com.ypwang.medium

class Solution3627 {
    fun maximumMedianSum(nums: IntArray): Long {
        nums.sort()
        val n = nums.size / 3
        var rst = 0L

        for (i in 1 .. n)
            rst += nums[nums.size - 2 * i]

        return rst
    }
}
