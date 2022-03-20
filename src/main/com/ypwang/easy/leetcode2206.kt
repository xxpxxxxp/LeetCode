package com.ypwang.easy

class Solution2206 {
    fun divideArray(nums: IntArray): Boolean =
        nums.groupBy { it }.all { it.value.size % 2 == 0 }
}