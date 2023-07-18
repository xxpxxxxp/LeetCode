package com.ypwang.medium

class Solution2780 {
    fun minimumIndex(nums: List<Int>): Int {
        val len = nums.size
        val (x, y) = nums.groupBy { it }.mapValues { it.value.size }.toList().single { it.second * 2 > len }
        var c = 0
        for (i in 0 until nums.lastIndex) {
            if (nums[i] == x)
                c++
            if (c * 2 > i+1 && (y - c) * 2 > len-i-1)
                return i
        }

        return -1
    }
}