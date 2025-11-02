package com.ypwang.medium

class Solution3732 {
    fun maxProduct(nums: IntArray): Long {
        var a = 0L
        var b = 0L
        for (x in nums) {
            val ax = Math.abs(x).toLong()
            if (ax >= a) {
                b = a
                a = ax
            } else if (ax > b) {
                b = ax
            }
        }
        return 100000L * a * b
    }
}
