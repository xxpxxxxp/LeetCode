package com.ypwang.medium

class Solution162 {
    fun findPeakElement(nums: IntArray): Int {
        var l = 0
        var r = nums.lastIndex
        while (l < r) {
            val mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid
            else
                l = mid + 1
        }
        return l
    }
}