package com.ypwang.easy

class Solution3684 {
    fun maxKDistinct(nums: IntArray, k: Int): IntArray =
        nums.toSet().sortedDescending().take(k).toIntArray()
}