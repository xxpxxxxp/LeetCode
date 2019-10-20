package com.ypwang.medium

class Solution1223 {
    fun dieSimulator(n: Int, rollMax: IntArray): Int {
        val mod = 1000000007

        val dp = Array(n+1){ IntArray(7) }
        dp[0] = intArrayOf(0,0,0,0,0,0,1)

        for (i in 1..n) {
            var sum = 0
            for (j in 0 until 6) {
                // round i, end with j die
                dp[i][j] = dp[i-1].last()
                // enough repeating
                if (i - rollMax[j] - 1 >= 0)
                    dp[i][j] =
                        (((dp[i][j] - dp[i - rollMax[j] - 1][6]) % mod
                                    + dp[i - rollMax[j] - 1][j]) % mod
                                    + mod) % mod
                sum = (sum + dp[i][j]) % mod
            }
            dp[i][6] = sum.toInt()
        }

        return dp.last().last()
    }
}

fun main() {
    println(Solution1223().dieSimulator(30, intArrayOf(2,3,1,2,1,2)))
    println(Solution1223().dieSimulator(2, intArrayOf(1,1,2,2,2,3)))
    println(Solution1223().dieSimulator(2, intArrayOf(1,1,1,1,1,1)))
    println(Solution1223().dieSimulator(3, intArrayOf(1,1,1,2,2,3)))
    println(Solution1223().dieSimulator(4, intArrayOf(2,1,1,3,3,2)))
}