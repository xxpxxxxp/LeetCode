package com.ypwang.medium

class Solution2679 {
    fun matrixSum(nums: Array<IntArray>): Int {
        nums.forEach { it.sortDescending() }
        return nums[0].indices.map { j ->
            nums.map { it[j] }.max()!!
        }.sum()!!
    }
}