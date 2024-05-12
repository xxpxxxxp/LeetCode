package com.ypwang.medium

class Solution3148 {
    fun maxScore(grid: List<List<Int>>): Int {
        val dp = grid.map { it.toIntArray() }.toTypedArray()
        val m = dp.size
        val n = dp[0].size

        var rst = Int.MIN_VALUE
        for (i in 0 until m) {
            for (j in 0 until n) {
                val pre = minOf(
                    if (i > 0) dp[i - 1][j] else Int.MAX_VALUE,
                    if (j > 0) dp[i][j - 1] else Int.MAX_VALUE,
                )
                rst = maxOf(rst, dp[i][j] - pre)
                if (pre < dp[i][j])
                    dp[i][j] = pre
            }
        }
        return rst
    }
}
