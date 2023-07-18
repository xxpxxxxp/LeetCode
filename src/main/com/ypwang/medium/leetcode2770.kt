package com.ypwang.medium

class Solution2770 {
    fun maximumJumps(nums: IntArray, target: Int): Int {
        val dp = IntArray(nums.size) { -1 }
        dp[0] = 0
        for (i in 1 until nums.size) {
            for (j in 0 until i) {
                if (dp[j] != -1 && Math.abs((nums[j] - nums[i])) <= target)
                    dp[i] = maxOf(dp[i], dp[j] + 1)
            }
        }
        return dp.last()
    }
}
