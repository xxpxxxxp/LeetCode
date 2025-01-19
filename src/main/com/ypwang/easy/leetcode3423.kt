package com.ypwang.easy

class Solution3423 {
    fun maxAdjacentDistance(nums: IntArray): Int {
        var rst = Int.MIN_VALUE
        for (i in 0 until nums.size)
            rst = maxOf(rst, Math.abs(nums[(i+1) % nums.size] - nums[i]))

        return rst
    }
}
