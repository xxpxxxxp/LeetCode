package com.ypwang.medium

class Solution2150 {
    fun findLonely(nums: IntArray): List<Int> {
        val s = nums.toMutableSet()
        return nums.groupBy { it }
            .filter { it.value.size == 1 }
            .map { it.key }
            .filter { it+1 !in s && it-1 !in s }
    }
}