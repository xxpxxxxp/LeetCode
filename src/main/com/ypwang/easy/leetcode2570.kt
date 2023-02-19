package com.ypwang.easy

class Solution2570 {
    fun mergeArrays(nums1: Array<IntArray>, nums2: Array<IntArray>): Array<IntArray> {
        val rst = mutableListOf<IntArray>()
        var i = 0
        var j = 0
        while (i < nums1.size && j < nums2.size) {
            val (i1, v1) = nums1[i]
            val (i2, v2) = nums2[j]
            if (i1 < i2) {
                rst.add(nums1[i++])
            } else if (i1 > i2) {
                rst.add(nums2[j++])
            } else {
                rst.add(intArrayOf(i1, v1 + v2))
                i++
                j++
            }
        }
        rst.addAll(nums1.drop(i))
        rst.addAll(nums2.drop(j))

        return rst.toTypedArray()
    }
}