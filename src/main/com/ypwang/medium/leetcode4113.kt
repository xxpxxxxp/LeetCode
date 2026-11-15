package com.ypwang.medium

class Solution4113 {
    fun maxDifference(nums: IntArray): Long {
        val n = nums.size
        var dp2 = 0L
        var dp1 = nums[n - 1].toLong()
        for (i in n - 2 downTo 0) {
            val one = nums[i] + (if (nums[i] % 3 != 0) dp1 else -dp1)
            val two = nums[i] + nums[i + 1] + (if ((nums[i] + nums[i + 1]) % 3 != 0) dp2 else -dp2)
            dp2 = dp1
            dp1 = maxOf(one, two)
        }
        return dp1
    }
}
