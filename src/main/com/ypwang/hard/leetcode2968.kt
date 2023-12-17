package com.ypwang.hard

class Solution2968 {
    fun maxFrequencyScore(nums: IntArray, k: Long): Int {
        var i = 0
        var rst = 0
        var cur = 0L
        nums.sort()
        for (j in nums.indices) {
            cur += nums[j] - nums[(i + j) / 2]
            while (cur > k) {
                cur -= nums[(i + j + 1) / 2] - nums[i]
                i++
            }
            rst = maxOf(rst, j - i + 1)
        }
        return rst
    }
}