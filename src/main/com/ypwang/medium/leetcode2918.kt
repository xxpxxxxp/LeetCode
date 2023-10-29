package com.ypwang.medium

class Solution2918 {
    fun minSum(nums1: IntArray, nums2: IntArray): Long {
        var c1 = 0
        var s1 = 0L
        var c2 = 0
        var s2 = 0L
        for (n in nums1) {
            s1 += n
            if (n == 0)
                c1++
        }
        for (n in nums2) {
            s2 += n
            if (n == 0)
                c2++
        }

        if (c1 == 0 && c2 == 0)
            return if (s1 == s2) s1 else -1L

        if (c1 == 0)
            return if (s1 < s2 + c2) -1 else s2 + maxOf(c2.toLong(), s1 - s2)

        if (c2 == 0)
            return if (s2 < s1 + c1) -1 else s1 + maxOf(c1.toLong(), s2 - s1)

        return maxOf(s1 + c1, s2 + c2)
    }
}