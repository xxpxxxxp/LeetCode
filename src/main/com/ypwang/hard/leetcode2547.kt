package com.ypwang.hard

class Solution2547 {
    fun minCost(nums: IntArray, k: Int): Int {
        val n = nums.size
        val trimmed = Array(n) { IntArray(n) }
        for (i in 0 until n) {
            var curr = 0
            val freq = IntArray(n)
            for (j in i until n) {
                freq[nums[j]]++
                if (freq[nums[j]] == 2) {
                    curr += 2
                } else if (freq[nums[j]] > 2) {
                    curr++
                }
                trimmed[i][j] = curr
            }
        }
        val dp = IntArray(n + 1)
        for (i in 1..n) {
            var min = Int.MAX_VALUE
            for (j in 0 until i)
                min = minOf(min, dp[j] + k + trimmed[j][i - 1])
            dp[i] = min
        }
        return dp[n]
    }
}