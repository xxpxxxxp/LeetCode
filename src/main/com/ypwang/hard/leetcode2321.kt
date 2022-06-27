package com.ypwang.hard

class Solution2321 {
    fun maximumsSplicedArray(nums1: IntArray, nums2: IntArray): Int {
        val sum1 = nums1.sum()
        val sum2 = nums2.sum()
        var first = 0
        var second = 0
        var max1 = 0
        var max2 = 0
        for (i in nums1.indices) {
            first += nums2[i] - nums1[i]
            second += nums1[i] - nums2[i]
            max1 = maxOf(max1, first)
            max2 = maxOf(max2, second)
            first = maxOf(first, 0)
            second = maxOf(second, 0)
        }
        return maxOf(sum1 + max1, sum2 + max2)
    }
}