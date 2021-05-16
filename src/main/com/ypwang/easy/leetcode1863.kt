package com.ypwang.easy

class Solution1863 {
    fun subsetXORSum(nums: IntArray): Int =
        (1 until (1 shl nums.size)).sumBy { mask ->
            nums.withIndex().filter { mask and (1 shl it.index) > 0 }.map { it.value }.reduce { a, b -> a xor b }
        }
}