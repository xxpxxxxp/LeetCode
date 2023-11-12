package com.ypwang.medium

class Solution2934 {
    private fun helper(n1: IntArray, n2: IntArray): Int {
        var c = 0
        var m1 = n1.last()
        var m2 = n2.last()

        for (i in 0 until n1.size) {
            if (n1[i] <= m1 && n2[i] <= m2)
                continue

            if (n1[i] > m2 || n2[i] > m1)
                return -1

            c++
        }

        return c
    }

    fun minOperations(nums1: IntArray, nums2: IntArray): Int {
        val c1 = helper(nums1, nums2)

        val t = nums1.last()
        nums1[nums1.lastIndex] = nums2.last()
        nums2[nums2.lastIndex] = t

        val c2 = helper(nums1, nums2)

        return if (c1 == -1) {
            if (c2 == -1)
                -1
            else
                c2 + 1
        } else {
            if (c2 == -1)
                c1
            else
                minOf(c1, c2 + 1)
        }
    }
}