package com.ypwang.hard

class Solution1955 {
    private val mod = 1000000007

    fun countSpecialSubsequences(nums: IntArray): Int =
        nums.fold(IntArray(3)) { dp, a ->
            dp[a] = ((dp[a] + dp[a]) % mod + if (a > 0) dp[a - 1] else 1) % mod
            dp
        }[2]
}