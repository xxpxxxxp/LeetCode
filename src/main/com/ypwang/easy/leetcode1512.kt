package com.ypwang.easy

class Solution1512 {
    fun numIdenticalPairs(nums: IntArray): Int =
        nums.groupBy { it }.map { it.value.size }.sumBy { it * (it - 1) / 2 }
}