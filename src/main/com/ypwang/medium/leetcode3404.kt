package com.ypwang.medium

class Solution3404 {
    fun numberOfSubsequences(nums: IntArray): Long {
        val n = nums.size
        var res = 0L
        val cnt = mutableMapOf<Double, Int>()
        for (r in 3 until n - 2) {
            val q = r - 2
            for (p in 0 until q - 1) {
                val key = nums[p].toDouble() / nums[q]
                cnt[key] = cnt.getOrDefault(key, 0) + 1
            }
            for (s in r + 2 until n) {
                val key = nums[s].toDouble() / nums[r]
                res += cnt.getOrDefault(key, 0)
            }
        }
        return res
    }
}
