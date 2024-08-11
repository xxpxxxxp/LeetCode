package com.ypwang.hard

class Solution3251 {
    fun countOfPairs(nums: IntArray): Int {
        val n = nums.size
        val m = 1001
        val mod = 1000000007
        var dp = IntArray(m) { 1 }

        for (i in 1 until n) {
            val d = maxOf(0, nums[i] - nums[i - 1])
            val dp2 = IntArray(m)
            for (j in d until nums[i] + 1) {
                dp2[j] = ((if (j > 0) dp2[j - 1] else 0) + dp[j - d]) % mod
            }
            dp = dp2
        }

        var res = 0
        for (j in 0..nums[n - 1])
            res = (res + dp[j]) % mod
        return res
    }
}
