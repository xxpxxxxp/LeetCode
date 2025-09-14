package com.ypwang.easy

class Solution3678 {
    fun smallestAbsent(nums: IntArray): Int {
        val a = nums.average().toInt()
        val s = nums.toSet()
        return (maxOf(a+1, 1) until a + 200).first { it !in s }
    }
}
