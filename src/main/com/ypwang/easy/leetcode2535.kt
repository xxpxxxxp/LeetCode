package com.ypwang.easy

class Solution2535 {
    fun differenceOfSum(nums: IntArray): Int =
        Math.abs(nums.map { it - it.toString().map { n -> n - '0' }.sum() }.sum())
}