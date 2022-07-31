package com.ypwang.easy

class Solution2357 {
    fun minimumOperations(nums: IntArray): Int =
        nums.filter { it != 0 }.toSet().size
}