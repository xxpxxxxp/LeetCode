package com.ypwang.easy

class Solution1920 {
    fun buildArray(nums: IntArray): IntArray =
        IntArray(nums.size) { nums[nums[it]] }
}