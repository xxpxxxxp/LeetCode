package com.ypwang.medium

class Solution3409 {
    fun longestSubsequence(nums: IntArray): Int {
        // Create a 2D array for dynamic programming
        val dp = Array(302) { IntArray(302) }

        // Iterate through the array from right to left
        for (i in nums.indices.reversed()) {
            val num = nums[i]

            // For each possible next number
            for (next in 1..300) {
                val diff = Math.abs(next - num)
                dp[num][diff] = maxOf(dp[num][diff], dp[next][diff] + 1)
            }

            // Update dp values for current number
            for (j in 1..300)
                dp[num][j] = maxOf(dp[num][j], dp[num][j - 1])
        }

        // Find the maximum value in dp array
        var ans = Int.MIN_VALUE
        for (i in 0..301)
            for (j in 0..301)
                ans = maxOf(ans, dp[i][j])

        return ans
    }
}
