package com.ypwang.hard

class Solution3753 {
    fun totalWaviness(num1: Long, num2: Long): Long =
        f(
            0,
            1,
            0,
            -1,
            -1,
            0,
            num2.toString(),
            Array(16) { Array(2) { Array(2) { Array(11) { Array(11) { LongArray(16) { -1L } } } } } }) -
                f(
                    0,
                    1,
                    0,
                    -1,
                    -1,
                    0,
                    (num1 - 1).toString(),
                    Array(16) { Array(2) { Array(2) { Array(11) { Array(11) { LongArray(16) { -1L } } } } } }
                )

    fun f(
        index: Int, tight: Int, validNum: Int, last2: Int, last1: Int, sc: Int, s: String,
        dp: Array<Array<Array<Array<Array<LongArray>>>>>
    ): Long {
        if (index == s.length)
            return if (validNum == 1) sc.toLong() else 0

        if (dp[index][tight][validNum][last2 + 1][last1 + 1][sc] != -1L)
            return dp[index][tight][validNum][last2 + 1][last1 + 1][sc]

        val dig = s[index] - '0'
        val limit = if (tight == 1) dig else 9
        var ans = 0L
        for (d in 0..limit) {
            val newTight = if (tight == 1 && d == dig) 1 else 0
            if (validNum == 0 && d == 0)
                ans += f(index + 1, newTight, 0, -1, -1, 0, s, dp)
            else if (validNum == 0)
                ans += f(index + 1, newTight, 1, -1, d, 0, s, dp)
            else if (last2 == -1)
                ans += f(index + 1, newTight, 1, last1, d, sc, s, dp)
            else {
                val score = if ((last1 > d && last1 > last2) || (last1 < d && last1 < last2)) 1 else 0
                ans += f(index + 1, newTight, 1, last1, d, sc + score, s, dp)
            }
        }

        return ans.also { dp[index][tight][validNum][last2 + 1][last1 + 1][sc] = it }
    }
}
