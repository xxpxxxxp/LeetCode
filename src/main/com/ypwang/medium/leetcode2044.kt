package com.ypwang.medium

class Solution2044 {
    fun countMaxOrSubsets(nums: IntArray): Int {
        var max = 0
        val dp = IntArray(1 shl 17)
        dp[0] = 1
        for (n in nums) {
            for (i in max downTo 0) {
                dp[n or i] += dp[i]
            }

            max = max or n
        }

        return dp[max]
    }
}