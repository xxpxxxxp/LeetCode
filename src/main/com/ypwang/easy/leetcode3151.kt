package com.ypwang.easy

class Solution3151 {
    fun isArraySpecial(nums: IntArray): Boolean =
        (1 until nums.size).all { (nums[it-1] xor nums[it]) and 0x1 == 1 }
}