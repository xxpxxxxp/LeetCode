package com.ypwang.easy

class Solution3487 {
    fun maxSum(nums: IntArray): Int = nums.toSet().filter { it > 0 }.let {
        if (it.isEmpty()) nums.max()!!
        else it.sum()!!
    }
}
