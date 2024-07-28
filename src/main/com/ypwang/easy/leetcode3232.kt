package com.ypwang.easy

class Solution3232 {
    fun canAliceWin(nums: IntArray): Boolean {
        val sum = nums.sum()!!
        val single = nums.filter { it < 10 }.sum()!!
        if (single * 2 > sum)
            return true

        val double = nums.filter { it in 10 until 100 }.sum()!!
        if (double * 2 > sum)
            return true

        return false
    }
}
