package com.ypwang.medium

class Solution3429 {
    fun minCost(n: Int, cost: Array<IntArray>): Long {
        val dp = Array(n / 2 + 1) { Array(4) { LongArray(4) { -1 } } }
        return solve(cost, 3, 3, 0, dp)
    }

    private fun solve(cost: Array<IntArray>, l: Int, r: Int, i: Int, dp: Array<Array<LongArray>>): Long {
        val n = cost.size
        if (i >= n / 2)
            return 0

        if (dp[i][l][r] != -1L)
            return dp[i][l][r]

        val leftChoices = mutableListOf<Int>()
        val rightChoices = mutableListOf<Int>()
        for (j in 0..2) {
            if (l != j)
                leftChoices.add(j)

            if (r != j)
                rightChoices.add(j)
        }
        var ans = Long.MAX_VALUE
        for (h in leftChoices) {
            for (j in rightChoices) {
                if (h == j)
                    continue
                val cl = cost[i][h].toLong()
                val cr = cost[n - i - 1][j].toLong()
                ans = minOf(ans, cl + cr + solve(cost, h, j, i + 1, dp))
            }
        }
        dp[i][l][r] = ans
        return ans
    }
}
