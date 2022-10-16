package com.ypwang.medium

class Solution2439 {
    fun minimizeArrayValue(nums: IntArray): Int {
        var max = Int.MIN_VALUE
        var sum = 0.0

        for ((i, n) in nums.withIndex()) {
            sum += n
            max = maxOf(Math.ceil(sum / (i + 1)).toInt(), max)
        }

        return max
    }
}