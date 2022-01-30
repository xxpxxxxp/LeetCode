package com.ypwang.easy

class Solution2154 {
    fun findFinalValue(nums: IntArray, original: Int): Int {
        val set = nums.toSet()
        var o = original
        while (o in set) {
            o *= 2
        }
        return o
    }
}