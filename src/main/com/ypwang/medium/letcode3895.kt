package com.ypwang.medium

class Solution3895 {
    fun countDigitOccurrences(nums: IntArray, digit: Int): Int =
        nums.sumOf { it.toString().count { c -> c - '0' == digit } }
}
