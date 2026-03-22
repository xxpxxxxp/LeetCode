package com.ypwang.medium

class Solution3877 {
    fun minRemovals(nums: IntArray, target: Int): Int {
        val dp = Array(41) { IntArray(100000) { -1 } }

        fun solve(i: Int, temp: Int): Int {
            if (i >= nums.size)
                return if (temp == target) 0 else 50

            if (dp[i][temp] != -1)
                return dp[i][temp]

            val take = solve(i + 1, temp xor nums[i])
            val skip = 1 + solve(i + 1, temp)

            dp[i][temp] = minOf(take, skip)
            return dp[i][temp]
        }

        val ans = solve(0, 0)
        return if (ans > nums.size) -1 else ans
    }
}
