package com.ypwang.easy

class Solution3674 {
    fun minOperations(nums: IntArray): Int =
        if (nums.toSet().size > 1) 1 else 0
}
