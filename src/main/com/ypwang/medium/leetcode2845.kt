package com.ypwang.medium

class Solution2845 {
    fun countInterestingSubarrays(nums: List<Int>, modulo: Int, k: Int): Long {
        val n = nums.size
        val arr = LongArray(n + 1)
        val nm = mutableMapOf(0L to 1)
        var ans = 0L
        for ((i, v) in nums.withIndex()) {
            arr[i+1] = (arr[i] + if (v % modulo == k) 1 else 0) % modulo
            val `val` = (arr[i+1] - k + modulo) % modulo
            ans += nm.getOrDefault(`val`, 0)
            nm[arr[i+1]] = nm.getOrDefault(arr[i+1], 0) + 1
        }
        return ans
    }
}