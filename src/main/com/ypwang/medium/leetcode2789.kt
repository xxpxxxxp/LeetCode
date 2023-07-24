package com.ypwang.medium

class Solution2789 {
    fun maxArrayValue(nums: IntArray): Long {
        var max = Long.MIN_VALUE
        var cur = 0L

        for (v in nums.reversed()) {
            if (cur < v)
                cur = v.toLong()
            else
                cur += v

            max = maxOf(max, cur)
        }

        return max
    }
}