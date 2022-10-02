package com.ypwang.medium

class Solution2425 {
    fun xorAllNums(nums1: IntArray, nums2: IntArray): Int {
        var rst = 0
        if (nums1.size % 2 != 0)
            rst = rst xor nums2.reduce { a, b -> a xor b }
        if (nums2.size % 2 != 0)
            rst = rst xor nums1.reduce { a, b -> a xor b }
        return rst
    }
}
