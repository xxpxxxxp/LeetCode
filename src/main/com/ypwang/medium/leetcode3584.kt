package com.ypwang.medium

class Solution3584 {
    fun maximumProduct(nums: IntArray, m: Int): Long {
        var ma = nums[0].toLong()
        var mi = nums[0].toLong()
        var res = 1L * nums[0] * nums[m - 1]
        for (i in m - 1 until nums.size) {
            ma = maxOf(ma, nums[i - m + 1].toLong())
            mi = minOf(mi, nums[i - m + 1].toLong())
            res = maxOf(res, mi * nums[i], ma * nums[i])
        }
        return res
    }
}
