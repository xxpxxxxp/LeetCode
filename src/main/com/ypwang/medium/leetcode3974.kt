package com.ypwang.medium

class Solution3974 {
    fun maxSum(nums: IntArray, k: Int, mul: Int): Long {
        var k = k
        var mul = mul
        nums.sort()
        val n = nums.size
        var i = n - 1
        var ans = 0L
        while (k > 0) {
            ans += if (mul > 0)
                nums[i].toLong() * mul
            else nums[i].toLong()
            i--
            k--
            mul--
        }
        return ans
    }
}
