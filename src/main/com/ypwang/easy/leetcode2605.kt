package com.ypwang.easy

class Solution2605 {
    fun minNumber(nums1: IntArray, nums2: IntArray): Int {
        val t = nums1.intersect(nums2.toSet())
        if (t.isNotEmpty())
            return t.min()!!

        val a = nums1.min()!!
        val b = nums2.min()!!
        return minOf(a, b) * 10 + maxOf(a, b)
    }
}