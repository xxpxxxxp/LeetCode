package com.ypwang.easy

class Solution3131 {
    fun addedInteger(nums1: IntArray, nums2: IntArray): Int =
        nums2.min()!! - nums1.min()!!
}