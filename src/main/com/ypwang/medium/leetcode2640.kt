package com.ypwang.medium

class Solution2640 {
    fun findPrefixScore(nums: IntArray): LongArray {
        var max = Int.MIN_VALUE
        var sum = 0L
        val rst = LongArray(nums.size)

        for ((i, n) in nums.withIndex()) {
            max = maxOf(n, max)
            val c = n + max
            sum += c
            rst[i] = sum
        }

        return rst
    }
}