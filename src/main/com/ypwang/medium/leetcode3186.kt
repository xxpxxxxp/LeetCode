package com.ypwang.medium

class Solution3186 {
    fun maximumTotalDamage(power: IntArray): Long {
        val dp = LongArray(power.size + 1)
        power.sort()
        var maxDp = 0L
        for ((i, p) in power.withIndex()) {
            if (i == 0 || p == power[i - 1]) {
                dp[i + 1] = dp[i] + p
            } else {
                var j = 0
                while (j < i && power[j] + 2 < p) {
                    maxDp = maxOf(maxDp, dp[j + 1])
                    j++
                }
                dp[i + 1] = maxDp + p
            }
        }

        return dp.max()!!
    }
}
