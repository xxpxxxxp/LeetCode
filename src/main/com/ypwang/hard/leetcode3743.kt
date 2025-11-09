package com.ypwang.hard

class Solution3743 {
    fun maximumScore(nums: IntArray, k: Int): Long {
        // Find index of minimum element
        var j = 0
        for (i in nums.indices)
            if (nums[i] < nums[j]) j = i

        val n = nums.size
        val a = IntArray(n) { nums[(j + it) % n] }
        val b = IntArray(n) { nums[(j + 1 + it) % n] }
        b.reverse()

        return maxOf(f(a, k), f(b, k))
    }

    private fun f(a: IntArray, k: Int): Long {
        val n = a.size
        val dp = Array(k + 1) { LongArray(n + 1) }

        var mn = Long.MAX_VALUE
        var mx = Long.MIN_VALUE

        // Initialize dp[1][j+1]
        for (j in 0 until n) {
            mn = minOf(mn, a[j].toLong())
            mx = maxOf(mx, a[j].toLong())
            dp[1][j + 1] = mx - mn
        }

        var res = dp[1][n]
        for (i in 2..k) {
            var x = Long.MIN_VALUE
            var y = Long.MIN_VALUE
            for (j in i - 1 until n) {
                x = maxOf(x, dp[i - 1][j] - a[j])
                y = maxOf(y, dp[i - 1][j] + a[j])
                dp[i][j + 1] = maxOf(dp[i][j], x + a[j], y - a[j])
            }
            res = maxOf(res, dp[i][n])
        }

        return res
    }
}
