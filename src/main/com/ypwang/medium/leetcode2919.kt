package com.ypwang.medium

class Solution2919 {
    fun minIncrementOperations(nums: IntArray, k: Int): Long {
        var dp1 = 0L
        var dp2 = 0L
        var dp3 = 0L
        var dp = 0L
        for (a in nums) {
            dp = minOf(dp1, dp2, dp3) + maxOf(k - a, 0)
            dp1 = dp2
            dp2 = dp3
            dp3 = dp
        }
        return minOf(dp1, dp2, dp3)
    }
}