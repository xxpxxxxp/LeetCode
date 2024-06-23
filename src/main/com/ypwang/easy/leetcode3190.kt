package com.ypwang.easy

class Solution3190 {
    fun minimumOperations(nums: IntArray): Int =
        nums.map { minOf(it % 3, 3 - it % 3) }.sum()!!
}
