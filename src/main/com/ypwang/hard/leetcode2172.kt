package com.ypwang.hard

import kotlin.math.pow

class Solution2172 {
    fun maximumANDSum(nums: IntArray, numSlots: Int): Int {
        val mask = 3.0.pow(numSlots.toDouble()).toInt() - 1
        val memo = IntArray(mask + 1)
        return dp(nums.size - 1, mask, numSlots, memo, nums)
    }

    private fun dp(i: Int, mask: Int, numSlots: Int, memo: IntArray, nums: IntArray): Int {
        if (memo[mask] > 0)
            return memo[mask]

        if (i < 0)
            return 0

        var bit = 1
        for (slot in 1..numSlots) {
            if (mask / bit % 3 > 0)
                memo[mask] = maxOf(memo[mask], (nums[i] and slot) + dp(i - 1, mask - bit, numSlots, memo, nums))
            bit *= 3
        }

        return memo[mask]
    }
}