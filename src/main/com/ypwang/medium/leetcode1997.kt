package com.ypwang.medium

class Solution1997 {
    fun firstDayBeenInAllRooms(nextVisit: IntArray): Int {
        val dp = LongArray(nextVisit.size)
        for (i in 1 until nextVisit.size) {
            dp[i] = (2 * dp[i-1] - dp[nextVisit[i-1]] + 2 + 1000000007) % 1000000007
        }

        return dp.last().toInt()
    }
}