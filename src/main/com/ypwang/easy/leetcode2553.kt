package com.ypwang.easy

class Solution {
    fun separateDigits(nums: IntArray): IntArray = nums.joinToString("") { it.toString() }.map { it - '0' }.toIntArray()
}