package com.ypwang.easy

class Solution1752 {
    fun check(nums: IntArray): Boolean {
        var strict = false
        for (i in 0 until nums.lastIndex) {
            if (nums[i] <= nums[i+1])
                continue
            else {
                if (!strict)
                    strict = true
                else
                    return false
            }
        }
        return !strict || nums.first() >= nums.last()
    }
}