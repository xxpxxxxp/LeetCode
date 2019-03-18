package com.ypwang.medium

import java.util.Arrays

class Solution300 {
    fun lengthOfLIS(nums: IntArray): Int {
        val dp = IntArray(nums.size)
        var len = 0
        for (num in nums) {
            var i = Arrays.binarySearch(dp, 0, len, num)
            if (i < 0) {
                i = -(i + 1)
            }
            dp[i] = num
            if (i == len) {
                len++
            }
        }
        return len
    }
}