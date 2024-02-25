package com.ypwang.easy

class Solution3046 {
    fun isPossibleToSplit(nums: IntArray): Boolean =
        nums.groupBy { it }.map { it.value.size }.all { it <= 2 }
}