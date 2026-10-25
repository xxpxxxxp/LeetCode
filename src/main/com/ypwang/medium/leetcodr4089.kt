package com.ypwang.medium

class Solution4089 {
    fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long {
        var left = 0
        var count = 0L

        for (i in nums.indices) {
            if (nums[i] !in minK..maxK)
                left = i + 1
            else
                count = count + i - left + 1
        }
        return count
    }
}
