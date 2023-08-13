package com.ypwang.easy

class Solution2815 {
    fun maxSum(nums: IntArray): Int {
        val p = nums
            .groupBy { it.toString().max() }
            .values
            .filter { it.size > 1 }

        if (p.isEmpty())
            return -1

        return p
            .map { it.sortedDescending().take(2).sum()!! }
            .max()!!
    }
}