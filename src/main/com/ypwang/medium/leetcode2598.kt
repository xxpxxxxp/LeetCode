package com.ypwang.medium

class Solution2598 {
    fun findSmallestInteger(nums: IntArray, value: Int): Int {
        val mod = IntArray(value)
        for (n in nums) {
            if (n >= 0)
                mod[n % value]++
            else {
                val pos = n + (-(n / value) + 1) * value
                mod[pos % value]++
            }
        }
        val (m, n) = mod.withIndex().minBy { it.value }
        return m + n * value
    }
}

fun main() {
    println(Solution2598().findSmallestInteger(intArrayOf(1,-10,7,13,6,8), 5))
    println(Solution2598().findSmallestInteger(intArrayOf(1,-10,7,13,6,8), 7))
}