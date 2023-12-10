package com.ypwang.easy

class Solution2596 {
    fun findIntersectionValues(nums1: IntArray, nums2: IntArray): IntArray =
        intArrayOf(
            nums1.count { it in nums2.toSet() },
            nums2.count { it in nums1.toSet() },
        )
}