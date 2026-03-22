package com.ypwang.medium

class Solution3876 {
    fun uniformArray(nums1: IntArray): Boolean {
        val cnt = IntArray(2)
        var min = Int.MAX_VALUE
        for (v in nums1) {
            cnt[v % 2]++
            min = minOf(min, v)
        }

        return min % 2 == 1 || cnt[1] == 0
    }
}
