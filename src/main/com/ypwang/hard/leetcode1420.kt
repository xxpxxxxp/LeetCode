package com.ypwang.hard

class Solution1420 {
    fun numOfArrays(n: Int, m: Int, k: Int): Int {
        if (k == 0) return 0

        val mod = 1000000007
        // dp[jumped time][max till now]
        var dp = Array(k+1) { IntArray(m) }
        dp[1].fill(1)

        for (t in 1 until n) {
            for (jump in k downTo 1) {
                var sum = 0
                for (i in 0 until m) {
                    // no jump
                    dp[jump][i] = (dp[jump][i] * (i + 1L) % mod).toInt()
                    // jump
                    dp[jump][i] = (dp[jump][i] + sum) % mod
                    sum = (sum + dp[jump-1][i]) % mod
                }
            }
        }

        return dp.last().reduce { acc, i -> (acc + i) % mod }
    }
}

fun main() {
    println(Solution1420().numOfArrays(2,3,1))
    println(Solution1420().numOfArrays(5,2,3))
    println(Solution1420().numOfArrays(9,1,1))
    println(Solution1420().numOfArrays(50,100,25))
    println(Solution1420().numOfArrays(37,17,7))
}