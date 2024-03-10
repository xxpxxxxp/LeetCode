package com.ypwang.hard

class Solution3077 {
    fun maximumStrength(nums: IntArray, k: Int): Long {
        val dp = Array(k+1) { LongArray(nums.size+1) }
        for (i in 1 until k+1) {
            var maxSum = Long.MIN_VALUE
            var cur = Long.MIN_VALUE
            val multiplier = if (i % 2 == 1) k+1-i else i-1-k
            for (j in i-1 until nums.size) {
                cur = maxOf(cur, dp[i-1][j]) + nums[j].toLong() * multiplier
                maxSum = maxOf(maxSum, cur)
                dp[i][j+1] = maxSum
            }
        }
        return dp.last().last()
    }
}
