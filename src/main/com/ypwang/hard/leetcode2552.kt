package com.ypwang.hard

class Solution2552 {
    fun countQuadruplets(nums: IntArray): Long {
        val dp = LongArray(nums.size)
        var ans = 0L
        for ((j, v) in nums.withIndex()) {
            var prevSmall = 0L
            for (i in 0 until j) {
                if (v > nums[i]) {
                    prevSmall++
                    ans += dp[i]
                } else if (v < nums[i]) {
                    dp[i] += prevSmall
                }
            }
        }
        return ans
    }
}