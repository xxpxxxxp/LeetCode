package com.ypwang.medium

class Solution3659 {
    fun partitionArray(nums: IntArray, k: Int): Boolean {
        if (nums.size % k != 0)
            return false

        return nums.groupBy { it }.all { it.value.size <= nums.size / k }
    }
}
