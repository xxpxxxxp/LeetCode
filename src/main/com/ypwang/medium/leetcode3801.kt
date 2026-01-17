package com.ypwang.medium

class Solution3801 {
    fun minOperations(nums: IntArray, target: IntArray): Int =
        nums.zip(target).filter { it.first != it.second }.map { it.first }.toSet().size
}
