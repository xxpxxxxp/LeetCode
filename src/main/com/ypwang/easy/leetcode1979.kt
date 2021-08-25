package com.ypwang.easy

class Solution1979 {
    fun findGCD(nums: IntArray): Int {
        var min = nums.min()!!
        var max = nums.max()!!

        while (min != 0) {
            val t = min
            min = max % min
            max = t
        }

        return max
    }
}