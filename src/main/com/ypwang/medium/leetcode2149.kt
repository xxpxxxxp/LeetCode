package com.ypwang.medium

class Solution2149 {
    fun rearrangeArray(nums: IntArray): IntArray {
        var p = 0
        var q = 0
        val rst = IntArray(nums.size)
        for (v in nums) {
            if (v > 0)
                rst[2*(p++)] = v
            else
                rst[1+2*(q++)] = v
        }

        return rst
    }
}