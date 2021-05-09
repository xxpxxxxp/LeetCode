package com.ypwang.medium

class Solution1855 {
    fun maxDistance(nums1: IntArray, nums2: IntArray): Int {
        var i = 0
        var j = 0
        var dis = 0

        while (i < nums1.size && j < nums2.size) {
            while (j < nums2.size && nums1[i] <= nums2[j])
                j++

            dis = maxOf(dis, j-1-i)
            i++
            j = maxOf(j, i)
        }

        return dis
    }
}