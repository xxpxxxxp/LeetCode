package com.ypwang.medium

class Solution3282 {
    fun findMaximumScore(nums: List<Int>): Long {
        var rst = 0L
        var max = 0
        for (n in nums) {
            rst += max
            max = maxOf(max, n)
        }

        return rst
    }
}
