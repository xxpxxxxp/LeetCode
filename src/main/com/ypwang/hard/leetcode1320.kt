package com.ypwang.hard

class Solution1320 {
    private fun d(a: Int, b: Int): Int {
        return Math.abs(a / 6 - b / 6) + Math.abs(a % 6 - b % 6)
    }

    fun minimumDistance(word: String): Int {
        val dp = IntArray(26)
        var res = 0
        var save = 0
        for (i in 0 until word.lastIndex) {
            val cur = word[i] - 'A'
            val next = word[i + 1] - 'A'
            for (a in 0..25) dp[cur] = maxOf(dp[cur], dp[a] + d(cur, next) - d(a, next))
            save = maxOf(save, dp[cur])
            res += d(cur, next)
        }
        return res - save
    }
}