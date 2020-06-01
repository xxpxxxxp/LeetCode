package com.ypwang.medium

class Solution1462 {
    fun checkIfPrerequisite(n: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): BooleanArray {
        val dp = Array(n){ BooleanArray(n) }

        for ((a, b) in prerequisites) {
            dp[a][b] = true
        }

        for (k in 0 until n) {
            for (i in 0 until n) {
                for (j in 0 until n) {
                    dp[i][j] = dp[i][j] || (dp[i][k] && dp[k][j])
                }
            }
        }

        return queries.map { (a, b) -> dp[a][b] }.toBooleanArray()
    }
}