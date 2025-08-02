package com.ypwang.medium

class Solution3469 {
    fun minCost(nums: IntArray): Int {
        val dp = Array(1001) { IntArray(1001) { -1 } }

        fun solve(i: Int, last: Int): Int {
            if (i + 1 >= nums.size)
                return maxOf(nums[last], if (i < nums.size) nums[i] else 0)
            if (dp[i][last] != -1)
                return dp[i][last]

            val rst = minOf(
                maxOf(nums[i], nums[i + 1]) + solve(i + 2, last),
                maxOf(nums[i], nums[last]) + solve(i + 2, i + 1),
                maxOf(nums[i + 1], nums[last]) + solve(i + 2, i)
            )

            dp[i][last] = rst
            return rst
        }

        return solve(1, 0)
    }
}
