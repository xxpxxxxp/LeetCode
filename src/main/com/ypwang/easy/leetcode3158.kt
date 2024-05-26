package com.ypwang.easy

class Solution3158 {
    fun duplicateNumbersXOR(nums: IntArray): Int =
        nums.groupBy { it }.filter { it.value.size > 1 }.map { it.key }.let { if (it.isEmpty()) 0 else it.reduce { acc, i -> acc xor i } }
}
