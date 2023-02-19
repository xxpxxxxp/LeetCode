package com.ypwang.medium

class Solution2568 {
    fun minImpossibleOR(nums: IntArray): Int {
        val set = nums.toSet()
        var a = 1
        while (a in set) {
            a = a shl 1
        }
        return a
    }
}