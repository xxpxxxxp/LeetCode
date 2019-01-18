package com.ypwang.easy

class Solution496 {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val a = mutableListOf<Int>()
        val b = mutableMapOf<Int, Int>()
        for (value in nums2) {
            while (!a.isEmpty() && value > a.last()) {
                b[a.last()] = value
                a.removeAt(a.lastIndex)
            }
            a.add(value)
        }
        return nums1.map { when (it) {
            in b -> b[it]!!
            else -> -1
        } }.toTypedArray().toIntArray()
    }
}
