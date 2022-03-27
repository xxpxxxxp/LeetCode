package com.ypwang.hard

class Solution2218 {
    fun maxValueOfCoins(piles: List<List<Int>>, k: Int): Int {
        val memo = Array(piles.size + 1) { IntArray(k + 1){ -1 } }
        return dp(piles, memo, 0, k)
    }

    fun dp(piles: List<List<Int>>, memo: Array<IntArray>, i: Int, k: Int): Int {
        if (k == 0 || i == piles.size)
            return 0
        if (memo[i][k] != -1)
            return memo[i][k]

        var res = dp(piles, memo, i + 1, k)
        var cur = 0
        for (j in 0 until minOf(piles[i].size, k)) {
            cur += piles[i][j]
            res = maxOf(res, cur + dp(piles, memo, i + 1, k - j - 1))
        }
        memo[i][k] = res
        return res
    }
}