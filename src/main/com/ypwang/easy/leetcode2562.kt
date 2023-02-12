package com.ypwang.easy

class Solution2562 {
    fun findTheArrayConcVal(nums: IntArray): Long {
        var rst = 0L
        for (i in 0 .. (nums.size-1) / 2) {
            if (i == nums.size - i - 1)
                rst += nums[i]
            else
                rst += (nums[i].toString() + nums[nums.lastIndex-i].toString()).toLong()
        }
        return rst
    }
}