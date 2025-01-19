package com.ypwang.easy

class Solution3427 {
    fun subarraySum(nums: IntArray): Int {
        val preSum = IntArray(nums.size+1)

        var rst = 0
        for (i in nums.indices) {
            preSum[i+1] = nums[i] + preSum[i]
            rst += preSum[i+1] - preSum[maxOf(0, i - nums[i])]
        }

        return rst
    }
}
