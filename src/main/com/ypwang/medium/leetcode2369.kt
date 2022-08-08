package com.ypwang.medium

class Solution2369 {
    fun validPartition(nums: IntArray): Boolean {
        val dp = booleanArrayOf(false, false, false, true)
        for (i in nums.indices) {
            dp[i % 4] = false
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) dp[i % 4] = dp[i % 4] or dp[(i + 2) % 4]
            if (i - 2 >= 0 && nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2]) dp[i % 4] = dp[i % 4] or dp[(i + 1) % 4]
            if (i - 2 >= 0 && nums[i] - 1 == nums[i - 1] && nums[i - 1] == nums[i - 2] + 1) dp[i % 4] = dp[i % 4] or dp[(i + 1) % 4]
        }
        return dp[(nums.size - 1) % 4]
    }
}