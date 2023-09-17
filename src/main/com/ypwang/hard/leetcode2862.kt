package com.ypwang.hard

class Solution2862 {
    fun maximumSum(nums: List<Int>): Long {
        var res = 0L
        for (k in 1..nums.size) {
            var cur = 0L
            var v = 1
            while (v * v * k <= nums.size) {
                cur += nums[k * v * v - 1]
                v++
            }
            res = maxOf(res, cur)
        }
        return res
    }
}