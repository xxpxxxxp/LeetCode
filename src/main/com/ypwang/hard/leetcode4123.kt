package com.ypwang.hard

class Solution4123 {
    fun minCost(nums: IntArray): Long {
        val n = nums.size
        var cnt = 0
        var mn = Int.MAX_VALUE
        var res = 0L + nums[0] + nums[n - 1]
        for (i in 1 until n - 1) {
            if (nums[i] < 0) {
                res += nums[i].toLong()
                cnt = cnt xor 1
            }
            mn = minOf(mn, Math.abs(nums[i]))
        }
        if (cnt > 0)
            res += mn.toLong()

        return res
    }
}
