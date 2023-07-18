package com.ypwang.easy

class Solution2778 {
    fun sumOfSquares(nums: IntArray): Int {
        val n = nums.size
        return nums.withIndex().filter { n % (it.index+1) == 0 }.sumOf { it.value * it.value }
    }
}