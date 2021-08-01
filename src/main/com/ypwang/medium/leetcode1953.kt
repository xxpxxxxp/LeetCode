package com.ypwang.medium

class Solution1953 {
    fun numberOfWeeks(milestones: IntArray): Long {
        val max = milestones.max()!!
        val sum = milestones.fold(0L){ acc, i -> acc + i } - max

        if (max > sum)
            return 2 * sum + 1

        return sum + max
    }
}