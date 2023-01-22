package com.ypwang.medium

class Solution2541 {
    fun minOperations(nums1: IntArray, nums2: IntArray, k: Int): Long {
        if (k == 0)
            return if (nums1.contentEquals(nums2)) 0L else -1L
        val diffs = nums1.zip(nums2).map { it.first - it.second }
        if (diffs.all { it % k == 0 } && diffs.sum() == 0)
            return diffs.map { Math.abs(it) / k.toLong() }.sum() / 2
        return -1
    }
}