package com.ypwang.medium

class Solution2555 {
    fun maximizeWin(prizePositions: IntArray, k: Int): Int {
        var res = 0
        var j = 0
        val dp = IntArray(prizePositions.size + 1)
        for (i in prizePositions.indices) {
            while (prizePositions[j] < prizePositions[i] - k)
                ++j
            dp[i+1] = maxOf(dp[i], i - j + 1)
            res = maxOf(res, i - j + 1 + dp[j])
        }
        return res
    }
}