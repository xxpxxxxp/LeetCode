package com.ypwang.medium

class Solution3259 {
    fun maxEnergyBoost(energyDrinkA: IntArray, energyDrinkB: IntArray): Long {
        val n = energyDrinkA.size
        val dp = Array(n) { LongArray(2) { -1 } }

        fun helper(i: Int, curr: Int): Long {
            if (i >= energyDrinkA.size)
                return 0
            if (dp[i][curr] != -1L)
                return dp[i][curr]

            dp[i][curr] = if (curr == 1)
                maxOf(energyDrinkA[i] + helper(i + 1, 1), helper(i + 1, 0))
            else
                maxOf(energyDrinkB[i] + helper(i + 1, 0), helper(i + 1, 1))

            return dp[i][curr]
        }

        return maxOf(helper(0, 1), helper(0, 0))
    }
}
