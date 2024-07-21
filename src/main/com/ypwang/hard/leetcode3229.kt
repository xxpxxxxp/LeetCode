package com.ypwang.hard

class Solution3229 {
    fun minimumOperations(nums: IntArray, target: IntArray): Long {
        var res = 0L
        var pre = 0L
        for ((a, b) in target.zip(nums)) {
            res += maxOf(a - b - pre, 0L)
            pre = (a - b).toLong()
        }
        return res + maxOf(-pre, 0L)
    }
}
