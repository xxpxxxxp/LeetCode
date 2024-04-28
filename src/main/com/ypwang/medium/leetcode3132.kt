package com.ypwang.medium

class Solution3132 {
    fun minimumAddedInteger(nums1: IntArray, nums2: IntArray): Int {
        nums1.sort()
        nums2.sort()
        val m = nums1.size
        val n = nums2.size
        var res = Int.MAX_VALUE
        for (i in 0 until m) {
            val diff = nums2[0] - nums1[i]
            var count = 1
            var k = i + 1
            var l = 1
            while ((k < m && l < n) && (nums2[l] - nums1[k]) >= diff) {
                if (nums2[l] - nums1[k] == diff) {
                    count++
                    l++
                    k++
                } else {
                    k++
                }
            }
            if (count == n)
                res = minOf(res, diff)
        }
        return res
    }
}
