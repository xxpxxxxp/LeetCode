package com.ypwang.easy

class Solution2042 {
    fun areNumbersAscending(s: String): Boolean {
        val nums = s.split(' ').filter { it.all { c -> c.isDigit() } }.map { it.toInt() }
        return (0 until nums.lastIndex).all { nums[it] < nums[it+1] }
    }
}