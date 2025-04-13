package com.ypwang.medium

class Solution3513 {
    fun uniqueXorTriplets(nums: IntArray): Int {
        val n = nums.size
        return if (n < 3) n else Integer.highestOneBit(n) shl 1
    }
}
