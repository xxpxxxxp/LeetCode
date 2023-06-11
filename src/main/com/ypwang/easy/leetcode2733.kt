package com.ypwang.easy

class Solution2733 {
    fun findNonMinOrMax(nums: IntArray): Int {
        if (nums.size < 3)
            return -1
        val min = nums.min()!!
        val max = nums.max()!!
        return nums.first { it != min && it != max }
    }
}