package com.ypwang.medium

class Solution1039 {
    fun minScoreTriangulation(A: IntArray): Int {
        val dp = Array(A.size){ IntArray(A.size){ Int.MAX_VALUE } }

        for (i in 0 until A.size-1) {
            dp[i][i+1] = 0
        }

        for (d in 2 until A.size) {
            for (i in 0 until A.size - d) {
                for (k in i+1 until i+d) {
                    dp[i][i+d] = minOf(dp[i][i+d], dp[i][k] + dp[k][i+d] + A[i] * A[k] * A[i+d])
                }
            }
        }

        return dp[0][A.size-1]
    }
}

fun main() {
    println(Solution1039().minScoreTriangulation(intArrayOf(1,3,1,4,1,5)))
}