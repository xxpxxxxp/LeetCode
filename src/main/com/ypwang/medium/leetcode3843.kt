package com.ypwang.medium

class Solution3843 {
    fun firstUniqueFreq(nums: IntArray): Int {
        val l = nums.groupBy { it }
            .map { it.key to it.value.size }
            .groupBy { it.second }
            .filter { it.value.size == 1 }
            .map { it.value.single().first }
            .toSet()

        if (l.isEmpty())
            return -1

        return nums.first { it in l }
    }
}
