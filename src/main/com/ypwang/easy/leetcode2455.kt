package com.ypwang.easy

class Solution2455 {
    fun averageValue(nums: IntArray): Int =
        nums.filter { it % 6 == 0 }.average().toInt()
}