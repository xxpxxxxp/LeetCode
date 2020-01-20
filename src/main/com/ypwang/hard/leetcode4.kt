package com.ypwang.hard

class Solution4 {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val (a1, a2) = if (nums1.size > nums2.size) (nums2 to nums1) else (nums1 to nums2)
        val m = a1.size
        val n = a2.size

        var left = 0
        var right = m
        val half_len = (m + n + 1) / 2
        while (true) {
            val mid = (left + right) / 2
            val j = half_len - mid
            if (mid < m && a2[j-1] > a1[mid]) left++
            else if (mid > 0 && a1[mid-1] > a2[j]) right--
            else {
                val maxOfLeft =
                        if (mid == 0) a2[j-1]
                        else if (j == 0) a1[mid-1]
                        else maxOf(a1[mid-1], a2[j-1])

                if ((m + n) % 2 == 1) return maxOfLeft.toDouble()

                val minOfRight =
                        if (mid == m) a2[j]
                        else if (j == n) a1[mid]
                        else minOf(a1[mid], a2[j])

                return (maxOfLeft + minOfRight) / 2.0
            }
        }
    }
}