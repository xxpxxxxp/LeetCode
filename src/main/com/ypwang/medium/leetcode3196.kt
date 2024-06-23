package com.ypwang.medium

class Solution3196 {
    fun maximumTotalCost(nums: IntArray): Long =
        (1 until nums.size).fold(longArrayOf(nums[0].toLong(), nums[0].toLong())) {
            (add, sub), i -> longArrayOf(maxOf(add, sub) + nums[i], add - nums[i])
        }.max()!!
}
