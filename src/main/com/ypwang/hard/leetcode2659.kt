package com.ypwang.hard

class Solution2659 {
    fun countOperationsToEmptyArray(nums: IntArray): Long {
        val pos = nums.withIndex().map { it.value to it.index }.toMap()
        nums.sort()
        return (1 until nums.size).fold(0L) { cur, i ->
            if (pos[nums[i]]!! < pos[nums[(i - 1)]]!!)
                cur + nums.size - i
            else
                cur
        } + nums.size
    }
}