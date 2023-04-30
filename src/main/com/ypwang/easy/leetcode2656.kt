package com.ypwang.easy

class Solution2656 {
    fun maximizeSum(nums: IntArray, k: Int): Int {
        val m = nums.max()!!
        return m * k + k * (k - 1) / 2
    }
}