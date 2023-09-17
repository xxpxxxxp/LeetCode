package com.ypwang.medium

class Solution2860 {
    fun countWays(nums: List<Int>): Int {
        val nums = nums.sorted()
        var rst = 0
        if (nums.first() != 0)
            rst++

        for ((i, v) in nums.withIndex()) {
            if (i+1 > v && (i+1 == nums.size || i+1 < nums[i+1]))
                rst++
        }

        return rst
    }
}