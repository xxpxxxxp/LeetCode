package com.ypwang.medium

class Solution10037 {
    fun maximumSetSize(nums1: IntArray, nums2: IntArray): Int {
        val s1 = nums1.toSet()
        val s2 = nums2.toSet()
        val common = s1.intersect(s2)
        val ex1 = minOf(s1.size - common.size, nums1.size/2)
        val ex2 = minOf(s2.size - common.size, nums1.size/2)
        return minOf(ex1 + ex2 + common.size, nums1.size)
    }
}