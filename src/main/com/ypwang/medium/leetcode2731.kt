package com.ypwang.medium

class Solution2731 {
    fun sumDistance(nums: IntArray, s: String, d: Int): Int {
        for ((i, v) in nums.withIndex()) {
            nums[i] =
            if (s[i] == 'L')
                v - d
            else
                v + d
        }

        nums.sort()
        var preSum = nums.fold(0L) { a, b -> a + b }
        var rst = 0L
        for ((i, v) in nums.withIndex()) {
            rst = (rst + preSum - (nums.size - i) * v.toLong()) % 1000000007
            preSum -= v
        }
        return rst.toInt()
    }
}