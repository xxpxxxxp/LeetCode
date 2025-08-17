package com.ypwang.medium

class Solution3654 {
    fun minArraySum(nums: IntArray, k: Int): Long {
        val dp = LongArray(k) { Long.MAX_VALUE }
        dp[0] = 0L
        var res = 0L
        for (a in nums) {
            res += a
            val index = (res % k).toInt()
            dp[index] = minOf(dp[index], res)
            res = dp[index]
        }
        return res
    }
}
