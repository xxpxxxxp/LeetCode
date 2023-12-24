package com.ypwang.easy

class Solution2974 {
    fun numberGame(nums: IntArray): IntArray {
        nums.sort()
        for (i in 0 until nums.size / 2) {
            val t = nums[i*2]
            nums[i*2] = nums[i*2+1]
            nums[i*2+1] = t
        }

        return nums
    }
}