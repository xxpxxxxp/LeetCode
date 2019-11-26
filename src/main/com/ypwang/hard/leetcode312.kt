package com.ypwang.hard

class Solution312 {
    fun maxCoins(nums: IntArray): Int {
        val nonEmpty = nums.filter { it != 0 }.toIntArray()
        if (nonEmpty.isEmpty()) return 0
        val dp = Array(nonEmpty.size){ IntArray(nonEmpty.size) }
        for (len in nonEmpty.indices) {
            for (i in 0 until (nonEmpty.size - len)) {
                // burst [i, i+len] to empty
                for (j in i..(i+len)) {
                    // j is the last one to burst in the interval
                    val leftBound = if (i == 0) 1 else nonEmpty[i-1]
                    val rightBound = if (i+len == nonEmpty.lastIndex) 1 else nonEmpty[i+len+1]
                    val leftInterval = if (j > i) dp[i][j-1] else 0     // left part, [i, j-1]
                    val rightInterval = if (i+len > j) dp[j+1][i+len] else 0    // right part, [j+1, i+len]
                    dp[i][i+len] = maxOf(dp[i][i+len],
                        leftBound * rightBound * nonEmpty[j]        // burst last balloon nonEmpty[j]
                           + leftInterval + rightInterval)
                }
            }
        }

        return dp[0][nonEmpty.lastIndex]
    }
}

fun main() {
    println(Solution312().maxCoins(intArrayOf(3,1,5,8)))
}