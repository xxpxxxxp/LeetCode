package com.ypwang.hard

class Solution2209 {
    fun minimumWhiteTiles(floor: String, numCarpets: Int, carpetLen: Int): Int {
        val dp = Array(floor.length + 1) { IntArray(numCarpets + 1) }
        for (i in 1..floor.length) {
            for (k in 0..numCarpets) {
                val jump = dp[i - 1][k] + (floor[i - 1] - '0')
                val cover =
                    if (k > 0)
                        dp[maxOf(i - carpetLen, 0)][k - 1]
                    else
                        1000
                dp[i][k] = minOf(cover, jump)
            }
        }
        return dp[floor.length][numCarpets]
    }
}