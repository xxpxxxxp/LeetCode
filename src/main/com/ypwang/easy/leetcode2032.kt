package com.ypwang.easy

class Solution2032 {
    fun twoOutOfThree(nums1: IntArray, nums2: IntArray, nums3: IntArray): List<Int> =
        listOf(nums1, nums2, nums3)
            .flatMap { it.toSet() }
            .groupBy { it }
            .filter { it.value.size > 1 }
            .map { it.key }
}