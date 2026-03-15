package com.ypwang.medium

class Solution3868 {
    fun minCost(nums1: IntArray, nums2: IntArray): Int {
        val counts = (nums1 + nums2).groupBy { it }
            .mapValues {
                val c = it.value.size
                if (c % 2 != 0)
                    return -1

                c / 2
            }

        return nums1.groupBy { it }
            .mapValues { it.value.size }
            .toList()
            .sumOf { (k, v) -> maxOf(0, v - counts.getOrDefault(k, 0)) }
    }
}
