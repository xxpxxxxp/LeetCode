package com.ypwang.medium

class Solution1968 {
    fun rearrangeArray(nums: IntArray): IntArray {
        val rst = IntArray(nums.size)
        nums.sort()
        for (i in nums.indices) {
            rst[i] =
                if (i % 2 == 0) nums[i/2]
                else nums[i/2 + (nums.size+1) / 2]
        }

        return rst
    }
}