package com.ypwang.hard

class Solution3181 {
    fun maxTotalReward(rewardValues: IntArray): Int {
        rewardValues.sort()

        val dp = IntArray(rewardValues.last())
        for (i in rewardValues.indices) {
            if (i == 0 || rewardValues[i - 1] != rewardValues[i]) {
                val lim = minOf(rewardValues[i], rewardValues.last() - rewardValues[i])
                for (x in 0 until lim)
                    dp[rewardValues[i] + dp[x]] = rewardValues[i] + dp[x]
            }
        }

        return rewardValues.last() + dp.max()!!
    }
}
