package com.ypwang.medium

class Solution3202 {
    fun maximumLength(nums: IntArray, k: Int): Int {
        var rst = 0
        for (v in 0 until k) {
            val dp = IntArray(k)
            for (a in nums) {
                dp[a % k] = maxOf(dp[a % k], dp[(v + k - a % k) % k] + 1)
                rst = maxOf(rst, dp[a % k])
            }
        }
        return rst
    }
}
