package com.ypwang.easy

class Solution1979 {
    fun findGCD(nums: IntArray): Int {
        var min = nums.minOrNull()!!
        var max = nums.maxOrNull()!!

        while (min != 0) {
            val t = min
            min = max % min
            max = t
        }

        return max
    }
}