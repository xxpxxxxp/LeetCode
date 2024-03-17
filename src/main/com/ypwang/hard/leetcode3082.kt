package com.ypwang.hard

class Solution3082 {
    fun sumOfPower(nums: IntArray, k: Int): Int {
        val dp = IntArray(101) { 0 }
        dp[0] = 1
        val mod = 1000000007
        for (n in nums)
            for (sum in k downTo 0)
                dp[sum] = ((2L * dp[sum] + if (sum >= n) dp[sum-n] else 0) % mod).toInt()

        return dp[k]
    }
}
