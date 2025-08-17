package com.ypwang.hard

class Solution3651 {
    fun minCost(grid: Array<IntArray>, k: Int): Int {
        val m = grid.size
        val n = grid[0].size
        val INF = Int.MAX_VALUE / 2

        var dp = Array(m) { IntArray(n) { INF } }
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0
                } else {
                    if (i > 0) dp[i][j] = minOf(dp[i][j], dp[i - 1][j])
                    if (j > 0) dp[i][j] = minOf(dp[i][j], dp[i][j - 1])
                    dp[i][j] += grid[i][j]
                }
            }
        }

        repeat(k) {
            val s = mutableListOf<Triple<Int, IntArray, Pair<Int, Int>>>()
            for (i in 0 until m) {
                for (j in 0 until n) {
                    s.add(Triple(-grid[i][j], intArrayOf(dp[i][j]), i to j))
                }
            }
            s.sortWith(compareBy({ it.first }, { it.second[0] }))

            val dpNext = Array(m) { IntArray(n) { INF } }
            var cc = INF

            for ((_, cArr, pos) in s) {
                val (i, j) = pos
                cc = minOf(cc, cArr[0])
                dpNext[i][j] = cc
            }

            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (i == 0 && j == 0) {
                        dpNext[i][j] = 0
                    } else {
                        if (i > 0) dpNext[i][j] = minOf(dpNext[i][j], dpNext[i - 1][j] + grid[i][j])
                        if (j > 0) dpNext[i][j] = minOf(dpNext[i][j], dpNext[i][j - 1] + grid[i][j])
                    }
                }
            }
            dp = dpNext
        }
        return dp[m - 1][n - 1]
    }
}
