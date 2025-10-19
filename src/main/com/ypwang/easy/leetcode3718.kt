package com.ypwang.easy

class Solution3718 {
    fun missingMultiple(nums: IntArray, k: Int): Int {
        val n = nums.toSet()
        return (1 .. nums.size+1).first { it * k !in n } * k
    }
}
