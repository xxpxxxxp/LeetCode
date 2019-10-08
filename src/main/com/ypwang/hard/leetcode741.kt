package com.ypwang.hard

class Solution741 {
    fun cherryPickup(grid: Array<IntArray>): Int {
        val n = grid.size
        var dp = Array(n){ IntArray(n){ Int.MIN_VALUE } }
        dp[0][0] = grid[0][0]

        for (t in 1..2*n-2) {
            val dp2 = Array(n){ IntArray(n){ Int.MIN_VALUE } }

            for (i in maxOf(0, t-n+1)..minOf(n-1, t)) {
                for (j in maxOf(0, t-n+1)..minOf(n-1, t)) {
                    if (grid[i][t-i] == -1 || grid[j][t-j] == -1) continue
                    var `val` = grid[i][t-i]
                    if (i != j) `val` += grid[j][t-j]
                    for (pi in i-1..i) {
                        for (pj in j-1..j) {
                            if (pi >= 0 && pj >= 0)
                                dp2[i][j] = maxOf(dp2[i][j], dp[pi][pj] + `val`)
                        }
                    }
                }
            }

            dp = dp2
        }

        return maxOf(0, dp[n-1][n-1])
    }
}