package com.ypwang.easy

class Solution747 {
    fun dominantIndex(nums: IntArray): Int {
        val max = nums.maxOrNull()!!
        return if (nums.all { it == max || it * 2 <= max }) nums.indexOf(max) else -1
    }
}