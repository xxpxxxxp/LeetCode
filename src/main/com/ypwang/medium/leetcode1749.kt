package com.ypwang.medium

class Solution1749 {
    fun maxAbsoluteSum(nums: IntArray): Int {
        var sum = 0
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE

        for (num in nums) {
            sum += num
            min = minOf(min, sum)
            max = maxOf(max, sum)
        }

        return maxOf(Math.abs(min), Math.abs(max), Math.abs(max - min))
    }
}