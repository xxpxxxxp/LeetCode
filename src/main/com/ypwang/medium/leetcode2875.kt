package com.ypwang.medium

class Solution2875 {
    fun minSizeSubarray(nums: IntArray, target: Int): Int {
        var target = target
        var sumA = nums.fold(0L) { a, b -> a + b }
        var su = 0L
        val n = nums.size
        val k = (target / sumA).toInt()
        var res = n
        target %= sumA.toInt()
        if (target == 0)
            return k * n

        val dp = mutableMapOf(0L to -1)
        for (i in 0 until 2 * n) {
            su += nums[i % n].toLong()
            if (su - target in dp)
                res = minOf(res, i - dp[su - target]!!)
            dp[su] = i
        }
        return if (res < n) res + k * n else -1
    }
}