package com.ypwang.easy

class Solution3024 {
    fun triangleType(nums: IntArray): String {
        val (a, b, c) = nums.sorted()
        if (a + b <= c)
            return "none"
        return when (nums.groupBy { it }.size) {
            1 -> "equilateral"
            2 -> "isosceles"
            3 -> "scalene"
            else -> ""
        }
    }
}