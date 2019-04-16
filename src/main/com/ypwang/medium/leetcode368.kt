package com.ypwang.medium

class Solution368 {
    fun largestDivisibleSubset(nums: IntArray): List<Int> {
        if (nums.isEmpty()) return listOf()

        nums.sort()
        var overall = listOf(nums[0])
        val dp = Array(nums.size){ listOf<Int>() }
        dp[0] = overall
        for (i in 1 until nums.size) {
            var init = listOf<Int>()
            for (j in 0 until i) {
                if (nums[i] % nums[j] == 0 && dp[j].size > init.size) init = dp[j]
            }
            dp[i] = init + nums[i]

            if (dp[i].size > overall.size) overall = dp[i]
        }

        return overall
    }
}