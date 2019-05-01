package com.ypwang.medium

class Solution808 {
    fun soupServings(N: Int): Double {
        var n = N
        n = (n + 24) / 25
        if (n >= 500) return 1.0

        val memo = Array(n + 1) { DoubleArray(n + 1) }
        for (s in 0..2 * n) {
            for (i in 0..n) {
                val j = s - i
                if (j < 0 || j > n) continue
                var ans = 0.0
                if (i == 0) ans = 1.0
                if (i == 0 && j == 0) ans = 0.5
                if (i > 0 && j > 0) {
                    ans = 0.25 * (memo[M(i - 4)][j] + memo[M(i - 3)][M(j - 1)] +
                            memo[M(i - 2)][M(j - 2)] + memo[M(i - 1)][M(j - 3)])
                }
                memo[i][j] = ans

            }
        }
        return memo[n][n]
    }

    fun M(x: Int): Int = Math.max(0, x)
}