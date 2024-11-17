package com.ypwang.medium

class Solution3355 {
    fun isZeroArray(nums: IntArray, queries: Array<IntArray>): Boolean {
        val inc = IntArray(nums.size+1)
        for ((a, b) in queries) {
            inc[a]++
            inc[b+1]--
        }

        var c = 0
        for ((i, v) in nums.withIndex()) {
            c += inc[i]
            if (v > c)
                return false
        }

        return true
    }
}
