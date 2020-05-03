package com.ypwang.medium

class Solution1437 {
    fun kLengthApart(nums: IntArray, k: Int): Boolean {
        var idx = -100000
        for ((i, v) in nums.withIndex()) {
            if (v == 1) {
                if (i - idx <= k) return false
                idx = i
            }
        }

        return true
    }
}