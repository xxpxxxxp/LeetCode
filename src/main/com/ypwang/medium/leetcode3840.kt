package com.ypwang.medium

class Solution3840 {
    fun rob(nums: IntArray, colors: IntArray): Long {
        val n = nums.size

        var dp0 = 0L
        var dp1 = nums[0].toLong()
        for (i in 1 until n) {
            val new0: Long
            val new1: Long
            if (colors[i] == colors[i - 1]) {
                new0 = dp1
                new1 = dp0 + nums[i]
            } else {
                new0 = maxOf(dp1, dp0)
                new1 = maxOf(dp0, dp1) + nums[i]
            }

            dp0 = new0
            dp1 = new1
        }

        return maxOf(dp0, dp1)
    }
}
