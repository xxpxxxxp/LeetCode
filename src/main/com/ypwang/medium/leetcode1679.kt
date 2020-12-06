package com.ypwang.medium

class Solution1679 {
    fun maxOperations(nums: IntArray, k: Int): Int {
        val groups = nums.groupBy { it }.mapValues { it.value.size }

        var rst = 0
        for ((i, j) in groups) {
            rst +=
                if (i * 2 == k)
                    2 * (j / 2)
                else
                    minOf(j, groups.getOrDefault(k-i, 0))
        }

        return rst / 2
    }
}