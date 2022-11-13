package com.ypwang.easy

class Solution2465 {
    fun distinctAverages(nums: IntArray): Int {
        nums.sort()
        return (0 until nums.size/2).map { (nums[it] + nums[nums.lastIndex-it]) / 2.0 }.distinct().count()
    }
}