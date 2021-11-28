package com.ypwang.easy

class Solution2089 {
    fun targetIndices(nums: IntArray, target: Int): List<Int> =
        nums.sorted().withIndex().filter { it.value == target }.map { it.index }
}