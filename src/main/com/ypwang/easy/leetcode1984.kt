package com.ypwang.easy

class Solution1984 {
    fun minimumDifference(nums: IntArray, k: Int): Int {
        nums.sort()
        return (0..(nums.size-k)).fold(Int.MAX_VALUE) { cur, idx ->
            minOf(cur, nums[idx+k-1] - nums[idx])
        }
    }
}