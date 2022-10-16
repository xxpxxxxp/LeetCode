package com.ypwang.easy

class Solution2441 {
    fun findMaxK(nums: IntArray): Int {
        val set = nums.toSet()
        return nums.filter { -it in set }.map { Math.abs(it) }.maxOrNull() ?: -1
    }
}