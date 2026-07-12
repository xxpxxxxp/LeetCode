package com.ypwang.medium

class Solution3987 {
    fun minimumCost(nums: IntArray, k: Int): Int {
        val mod = 1000000007L
        val s = nums.fold(0L) { acc, i -> acc + i }
        val x = (s + k - 1) / k % mod
        return ((x - 1) * x / 2 % mod).toInt()
    }
}
