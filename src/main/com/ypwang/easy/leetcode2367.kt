package com.ypwang.easy

class Solution2367 {
    fun arithmeticTriplets(nums: IntArray, diff: Int): Int {
        val s = nums.toSet()
        return s.count { it + diff in s && it + 2 * diff in s }
    }
}