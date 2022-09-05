package com.ypwang.medium

class Solution2401 {
    fun longestNiceSubarray(nums: IntArray): Int {
        var used = 0
        var j = 0
        var res = 0
        for ((i, n) in nums.withIndex()) {
            while (used and n != 0)
                used = used xor nums[j++]
            used = used or nums[i]
            res = maxOf(res, i - j + 1)
        }
        return res
    }
}