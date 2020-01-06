package com.ypwang.easy

class Solution1295 {
    fun findNumbers(nums: IntArray): Int =
            nums.count { it.toString().length and 0x1 == 0 }
}