package com.ypwang.easy

class Solution3736 {
    fun minMoves(nums: IntArray): Int {
        val m = nums.max()!!

        return m * nums.size - nums.sum()
    }
}
