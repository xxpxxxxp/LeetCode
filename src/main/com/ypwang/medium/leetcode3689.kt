package com.ypwang.medium

class Solution3689 {
    fun maxTotalValue(nums: IntArray, k: Int): Long =
        k.toLong() * (nums.max() - nums.min())
}
