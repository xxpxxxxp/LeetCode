package com.ypwang.medium

class Solution2870 {
    fun minOperations(nums: IntArray): Int =
        nums.groupBy { it }.map { it.value.size }.map {
            if (it == 1)
                return -1

            val d = it / 3
            val m = it % 3
            if (m == 0)
                d
            else
                d+1
        }.sum()
}