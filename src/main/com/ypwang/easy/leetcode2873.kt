package com.ypwang.easy

class Solution2873 {
    fun maximumTripletValue(nums: IntArray): Long {
        var res = 0L
        var maxa = 0L
        var maxab = 0L
        for (a in nums) {
            res = maxOf(res, 1L * maxab * a)
            maxab = maxOf(maxab, maxa - a)
            maxa = maxOf(maxa, a.toLong())
        }
        return res
    }
}