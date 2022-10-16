package com.ypwang.hard

class Solution2444 {
    fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long {
        var res = 0L
        var j = 0
        var jmin = -1
        var jmax = -1
        for ((i, n) in nums.withIndex()) {
            if (n < minK || n > maxK) {
                jmax = -1
                jmin = -1
                j = i + 1
            }
            if (n == minK)
                jmin = i
            if (n == maxK)
                jmax = i

            res += maxOf(0, minOf(jmin, jmax) - j + 1)
        }
        return res
    }
}