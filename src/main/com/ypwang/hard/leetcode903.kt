package com.ypwang.hard

class Solution903 {
    fun numPermsDISequence(S: String): Int {
        val mod = 1000000007

        val cache = Array(S.length+1){ IntArray(S.length+1) }
        fun dp(i: Int, j: Int): Int {
            if (j < 0 || j > i) return 0
            if (i == 0) return 1
            if (cache[i][j] == 0) {
                cache[i][j] = when (S[i-1]) {
                    'D' -> (dp(i, j+1) + dp(i-1, j)) % mod
                    'I' -> (dp(i, j-1) + dp(i-1, j-1)) % mod
                    else -> 0
                }
            }

            return cache[i][j]
        }

        return (0..S.length).map { dp(S.length, it) }.reduce { a, b -> (a + b) % mod }
    }
}