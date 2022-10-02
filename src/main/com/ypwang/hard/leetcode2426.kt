package com.ypwang.hard

class Solution2426 {
    fun numberOfPairs(nums1: IntArray, nums2: IntArray, diff: Int): Long {
        val l = mutableListOf<Int>()
        var res = 0L
        for ((a, b) in nums1.zip(nums2)) {
            val d = a - b
            res += countSmallerEqual(l, d + diff)
            l.add(countSmallerEqual(l, d), d)
        }
        return res
    }

    private fun countSmallerEqual(l: List<Int>, target: Int): Int {
        var left = 0
        var right = l.size
        while (left < right) {
            val mid = (left + right) / 2
            if (l[mid] <= target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }
}