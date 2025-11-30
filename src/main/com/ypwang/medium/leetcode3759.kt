package com.ypwang.medium

class Solution3759 {
    fun countElements(nums: IntArray, k: Int): Int {
        val t = nums.groupBy { it }.mapValues { it.value.size }.toList().sortedBy { it.first }.toTypedArray()
        var c = 0
        for ((_, v) in t) {
            if (nums.size - c - v < k)
                break

            c += v
        }

        return c
    }
}
