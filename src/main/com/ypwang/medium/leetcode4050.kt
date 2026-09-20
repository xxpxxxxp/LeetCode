package com.ypwang.medium

class Solution4050 {
    fun minDays(n: Int): Int {
        val dp = IntArray(n + 1) { Int.MAX_VALUE }
        dp[0] = 0

        for (score in 1..n) {
            var sum = 0L

            for (k in 1..score) {
                sum += k

                if (sum > score)
                    break

                val remaining = score - sum.toInt()

                if (remaining == 0)
                    dp[score] = minOf(dp[score], k)
                else if (dp[remaining] != Int.MAX_VALUE) {
                    dp[score] = minOf(
                        dp[score],
                        dp[remaining] + k + 1
                    )
                }
            }
        }

        return dp[n]
    }
}
