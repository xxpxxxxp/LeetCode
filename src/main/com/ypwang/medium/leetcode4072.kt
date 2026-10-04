package com.ypwang.medium

class Solution4072 {
    fun maxAlternatingSum(nums: IntArray): Long {
        val inf: Long = 10000000
        var a0 = -inf
        var a1 = -inf
        var b0 = -inf
        var b1 = -inf
        var res = -inf
        for (a in nums) {
            val nb0 = maxOf(a0, b1 + a)
            b1 = maxOf(a1, b0 - a)
            b0 = nb0
            val na0 = maxOf(a1 + a, a.toLong())
            a1 = a0 - a
            a0 = na0
            res = maxOf(res, a0, a1, b0, b1)
        }
        return res
    }
}
