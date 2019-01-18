package com.ypwang.easy

class Solution88 {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i = m - 1
        var j = n - 1
        var l = m + n - 1
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[l] = nums1[i]
                i--
            } else {
                nums1[l] = nums2[j]
                j--
            }
            l--
        }
        if (j >= 0) {
            for (x in j downTo 0) {
                nums1[x] = nums2[x]
            }
        }
    }
}

fun main(args: Array<String>) {
    val nums1 = intArrayOf(1,2,3,0,0,0)
    Solution88().merge(nums1, 3, intArrayOf(2,5,6), 3)
    println(nums1.joinToString(","))
}