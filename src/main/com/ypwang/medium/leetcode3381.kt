package com.ypwang.medium

class Solution3381 {
    fun maxSubarraySum(nums: IntArray, k: Int): Long {
        val ps = LongArray(nums.size+1)
        for ((i, n) in nums.withIndex())
            ps[i+1] = ps[i] + n

        var rst = Long.MIN_VALUE
        for (p in 0 until k) {
            var sum = 0L
            for (i in p until nums.size - k + 1 step k) {
                val n = ps[i + k] - ps[i]
                sum = maxOf(n, sum + n)
                rst = maxOf(rst, sum)
            }
        }

        return rst
    }
}
