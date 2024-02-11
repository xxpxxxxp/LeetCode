package com.ypwang.medium

class Solution3026 {
    fun maximumSubarraySum(nums: IntArray, k: Int): Long {
        var sum = 0L
        val preSum = mutableMapOf<Int, Long>()
        var rst = Long.MIN_VALUE

        for (n in nums) {
            if (n-k in preSum)
                rst = maxOf(rst, n + sum - preSum[n-k]!!)

            if (n+k in preSum)
                rst = maxOf(rst, n + sum - preSum[n+k]!!)

            preSum[n] = minOf(sum, preSum.getOrDefault(n, Long.MAX_VALUE))
            sum += n
        }

        return if (rst == Long.MIN_VALUE) 0 else rst
    }
}
