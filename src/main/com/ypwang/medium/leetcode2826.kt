package com.ypwang.medium

class Solution2826 {
    fun minimumOperations(nums: List<Int>): Int {
        val n: Int = nums.size
        val dp = IntArray(4) { n }
        for (a in nums) {
            dp[a]--
            dp[2] = minOf(dp[2], dp[1])
            dp[3] = minOf(dp[3], dp[2])
        }
        return dp[3]
    }
}
