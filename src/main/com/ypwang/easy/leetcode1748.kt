package com.ypwang.easy

class Solution1748 {
    fun sumOfUnique(nums: IntArray): Int =
        nums.groupBy { it }.filter { it.value.size == 1 }.map { it.key }.sum()
}