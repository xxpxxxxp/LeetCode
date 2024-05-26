package com.ypwang.medium

class Solution3159 {
    fun occurrencesOfElement(nums: IntArray, queries: IntArray, x: Int): IntArray {
        val idx = nums.withIndex().filter { it.value == x }.map { it.index }.toIntArray()
        return queries.map { if (it <= idx.size) idx[it-1] else -1 }.toIntArray()
    }
}
