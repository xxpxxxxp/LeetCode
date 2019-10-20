package com.ypwang.medium

class Solution1230 {
    fun probabilityOfHeads(prob: DoubleArray, target: Int): Double {
        val dp = Array(prob.size + 1) { DoubleArray(target + 1) }
        dp[0][0] = 1.0

        for (i in 1 until dp.size) {
            val p = prob[i-1]
            dp[i][0] = dp[i-1][0] * (1 - p)
            for (j in 1..target) {
                dp[i][j] = dp[i-1][j-1] * p + dp[i-1][j] * (1 - p)
            }
        }

        return dp.last().last()
    }
}

fun main() {
    println(Solution1230().probabilityOfHeads(doubleArrayOf(0.4), 1))
    println(Solution1230().probabilityOfHeads(doubleArrayOf(0.5,0.5,0.5,0.5,0.5), 0))
}