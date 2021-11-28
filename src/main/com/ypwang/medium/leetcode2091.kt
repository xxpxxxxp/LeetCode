package com.ypwang.medium

class Solution2091 {
    fun minimumDeletions(nums: IntArray): Int {
        var minIdx = 0
        var maxIdx = 0

        for ((i, v) in nums.withIndex()) {
            if (v < nums[minIdx])
                minIdx = i

            if (v > nums[maxIdx])
                maxIdx = i
        }

        return minOf(maxOf(minIdx, maxIdx) + 1, nums.size - minOf(minIdx, maxIdx), minOf(minIdx, maxIdx) + 1 + nums.size - maxOf(minIdx, maxIdx))
    }
}