package com.ypwang.medium

class Solution2871 {
    fun maxSubarrays(nums: IntArray): Int {
        var v = -1
        var res = 0
        for (a in nums) {
            v = v and a
            if (v == 0) {
                v = -1
                res += 1
            }
        }
        return maxOf(1, res)
    }
}