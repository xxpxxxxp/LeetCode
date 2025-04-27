package com.ypwang.hard

class Solution3530 {
    fun maxProfit(n: Int, edges: Array<IntArray>, score: IntArray): Int {
        val need = IntArray(n)
        for ((i, j) in edges)
            need[j] = need[j] or (1 shl i)

        val dp = IntArray(1 shl n) { -1 }
        dp[0] = 0
        for (mask in 0..<(1 shl n)) {
            if (dp[mask] == -1)
                continue
            val pos = Integer.bitCount(mask) + 1
            for (i in 0..<n) {
                if (((mask shr i) and 1) == 0 && (mask and need[i]) == need[i]) {
                    val mask2 = mask or (1 shl i)
                    dp[mask2] = maxOf(dp[mask2], dp[mask] + score[i] * pos)
                }
            }
        }
        return dp[(1 shl n) - 1]
    }
}
