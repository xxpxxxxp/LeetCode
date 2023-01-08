package com.ypwang.medium

class Solution2527 {
    fun xorBeauty(nums: IntArray): Int = nums.reduce { acc, i -> acc xor i }
}