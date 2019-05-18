package com.ypwang.hard

class Solution629 {
    val mod = 1000000007

    fun kInversePairs(n: Int, k: Int): Int {
        if (n < 2) return if (k == 0) 1 else 0

        val dp = Array(n) { IntArray(k+1) {1} }

        for (i in 1..k) {
            dp[0][i] = 0
        }

        for (i in 1 until n) {
            for (j in 1..k) {
                val t = (dp[i-1][j] + mod - (if (j > i) dp[i-1][j-i-1] else 0)) % mod
                dp[i][j] = (t + dp[i][j-1]) % mod
            }
        }

        return dp.last().last()
    }
}

fun main() {
    println(Solution629().kInversePairs(1000, 1000))
}