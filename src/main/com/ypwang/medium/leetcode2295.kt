package com.ypwang.medium

class Solution2295 {
    fun arrayChange(nums: IntArray, operations: Array<IntArray>): IntArray {
        val posMap = nums.withIndex().associate { it.value to it.index }.toMutableMap()

        for ((a, b) in operations) {
            val pos = posMap[a]!!
            nums[pos] = b
            posMap.remove(a)
            posMap[b] = pos
        }

        return nums
    }
}