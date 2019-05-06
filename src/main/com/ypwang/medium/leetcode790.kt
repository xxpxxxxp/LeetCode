package com.ypwang.medium

/* for i
0     i
    ...
    ..

1     i
    ..
    ...

2     i
    ...
    ...
 */

class Solution790 {
    fun numTilings(N: Int): Int {
        val mod = 1000000007

        if (N < 2) return 1

        val dp = IntArray(N*3){0}
        dp[2] = 1
        dp[3] = 1
        dp[4] = 1
        dp[5] = 2

        for (i in 6 until 3*N) {
            dp[i] = when (i % 3) {
                0 -> (dp[i-4] + dp[i-2]) % mod
                1 -> (dp[i-5] + dp[i-4]) % mod
                2 -> (((dp[i-3] + dp[i-4]) % mod + dp[i-5]) % mod + dp[i - 6]) % mod
                else -> 0 // kotlin sucks
            }
        }

        return dp.last()
    }
}

fun main() {
    println(Solution790().numTilings(3))
}