package com.ypwang.medium

class Solution2419 {
    fun longestSubarray(nums: IntArray): Int {
        val max = nums.maxOrNull()!!
        var rst = 0
        var c = 0
        for (n in nums) {
            if (n == max)
                c++
            else {
                rst = maxOf(rst, c)
                c = 0
            }
        }

        return maxOf(rst, c)
    }
}