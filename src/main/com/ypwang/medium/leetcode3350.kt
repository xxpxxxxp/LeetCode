package com.ypwang.medium

class Solution3350 {
    fun maxIncreasingSubarrays(nums: List<Int>): Int {
        val n = nums.size
        var up = 1
        var preMaxUp = 0
        var res = 0

        for (i in 1 until n) {
            if (nums[i] > nums[i - 1])
                up++
            else {
                preMaxUp = up
                up = 1
            }
            res = maxOf(res, up / 2, minOf(preMaxUp, up))
        }
        return res
    }
}
