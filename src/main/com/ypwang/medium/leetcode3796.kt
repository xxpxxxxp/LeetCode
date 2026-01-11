package com.ypwang.medium

class Solution3796 {
    fun findMaxVal(n: Int, restrictions: Array<IntArray>, diff: IntArray): Int {
        val dp = IntArray(n) { Int.MAX_VALUE }
        dp[0] = 0
        for (r in restrictions)
            dp[r[0]] = r[1]

        for (i in 1 until n)
            dp[i] = minOf(dp[i], dp[i - 1] + diff[i - 1])
        for (i in n - 2 downTo 0)
            dp[i] = minOf(dp[i], dp[i + 1] + diff[i])
        return dp.max()
    }
}
