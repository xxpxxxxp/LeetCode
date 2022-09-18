package com.ypwang.medium

class Solution2411 {
    fun smallestSubarrays(nums: IntArray): IntArray {
        val last = IntArray(30)
        val res = IntArray(nums.size)
        for (i in nums.lastIndex downTo 0) {
            res[i] = 1
            for (j in 0..29) {
                if (nums[i] and (1 shl j) > 0)
                    last[j] = i
                res[i] = maxOf(res[i], last[j] - i + 1)
            }
        }
        return res
    }
}