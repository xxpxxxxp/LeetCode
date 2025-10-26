package com.ypwang.medium

class Solution3724 {
    fun minOperations(nums1: IntArray, nums2: IntArray): Long {
        val v = nums2.last()
        var last = 100000
        var res = 0L
        for (i in 0 until nums1.size) {
            val a = nums1[i]
            val b = nums2[i]
            res += Math.abs(a - b)
            if ((v in a..b) || (v in b..a))
                last = 0
            else
                last = minOf(last, Math.abs(a - v), Math.abs(b - v))
        }
        return res + last + 1
    }
}
