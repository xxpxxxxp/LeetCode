package com.ypwang.medium

class Solution1838 {
    fun maxFrequency(nums: IntArray, k: Int): Int {
        nums.sort()
        var s = 0
        var sum = k.toLong()
        var rst = 0
        for ((i, v) in nums.withIndex()) {
            sum += v
            while (sum < v.toLong() * (i - s + 1))
                sum -= nums[s++]

            rst = maxOf(rst, i - s + 1)
        }

        return rst
    }
}