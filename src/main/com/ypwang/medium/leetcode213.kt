package com.ypwang.medium

class Solution213 {
    private fun rob(nums: IntArray, lo: Int, hi: Int): Int {
        var start = Pair(0, 0)
        for (j in lo..hi) {
            val i = start.first
            val e = start.second
            start = Pair(e + nums[j], maxOf(e, i))
        }
        return maxOf(start.first, start.second)
    }


    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        return Math.max(rob(nums, 0, nums.lastIndex - 1), rob(nums, 1, nums.lastIndex))
    }
}