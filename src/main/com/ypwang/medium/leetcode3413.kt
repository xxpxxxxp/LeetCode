package com.ypwang.medium

class Solution3413 {
    fun maximumCoins(coins: Array<IntArray>, k: Int): Long {
        coins.sortBy { it[0] }
        val n = coins.size

        // Start at A[i][0]
        var res = 0L
        var cur = 0L
        var j = 0
        for (i in 0 until n) {
            while (j < n && coins[j][1] <= coins[i][0] + k - 1) {
                cur += 1L * (coins[j][1] - coins[j][0] + 1) * coins[j][2]
                j++
            }
            if (j < n) {
                val part = 1L * maxOf(0, coins[i][0] + k - 1 - coins[j][0] + 1) * coins[j][2]
                res = maxOf(res, cur + part)
            }
            cur -= 1L * (coins[i][1] - coins[i][0] + 1) * coins[i][2]
        }

        // End at A[i][1]
        cur = 0L
        j = 0
        for (i in 0 until n) {
            cur += 1L * (coins[i][1] - coins[i][0] + 1) * coins[i][2]
            while (j < n && coins[j][1] < coins[i][1] - k + 1) {
                cur -= 1L * (coins[j][1] - coins[j][0] + 1) * coins[j][2]
                j++
            }
            val part = 1L * maxOf(0, coins[i][1] - k - coins[j][0] + 1) * coins[j][2]
            res = maxOf(res, cur - part)
        }

        return res
    }
}
