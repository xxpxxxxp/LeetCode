package com.ypwang.medium

class Solution2294 {
    fun partitionArray(nums: IntArray, k: Int): Int {
        nums.sort()
        var cnt = 1
        var cur = nums.first()

        for (i in 1 until nums.size) {
            if (nums[i] - cur > k) {
                cnt++
                cur = nums[i]
            }
        }

        return cnt
    }
}