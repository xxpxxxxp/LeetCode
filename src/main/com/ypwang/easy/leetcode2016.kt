package com.ypwang.easy

class Solution2016 {
    fun maximumDifference(nums: IntArray): Int {
        var rst = Int.MIN_VALUE

        var cur = nums[0]
        for (i in 1 until nums.size) {
            rst = maxOf(rst, nums[i] - cur)
            cur = minOf(cur, nums[i])
        }

        cur = nums.last()
        for (i in nums.lastIndex-1 downTo 0) {
            rst = maxOf(rst, cur - nums[i])
            cur = maxOf(cur, nums[i])
        }

        return if (rst <= 0) -1 else rst
    }
}