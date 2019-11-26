package com.ypwang.hard

class Solution1250 {
    private fun gcd(a: Int, b: Int): Int = if (a == 0) b else gcd(b % a, a)
    fun isGoodArray(nums: IntArray): Boolean = nums.reduce { acc, i -> gcd(acc, i) } == 1
}