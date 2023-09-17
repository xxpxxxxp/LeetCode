package com.ypwang.easy

class Solution2859 {
    fun sumIndicesWithKSetBits(nums: List<Int>, k: Int): Int =
        nums.withIndex().filter { Integer.bitCount(it.index) == k }.map { it.value }.sum()
}