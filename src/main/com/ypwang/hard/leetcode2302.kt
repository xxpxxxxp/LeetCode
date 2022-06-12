package com.ypwang.hard

class Solution2302 {
    fun countSubarrays(nums: IntArray, k: Long): Long {
        var sum = 0L
        var rst = 0L
        var j = 0
        for ((i, v) in nums.withIndex()) {
            sum += v
            while (sum * (i - j + 1) >= k)
                sum -= nums[j++]
            rst += i - j + 1
        }
        return rst
    }
}