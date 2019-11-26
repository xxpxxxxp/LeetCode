package com.ypwang.hard

class Solution879 {
    private val mod = 1000000007

    fun profitableSchemes(G: Int, P: Int, group: IntArray, profit: IntArray): Int {
        val dp = Array(P+1){ IntArray(G+1) }
        dp[0][0] = 1

        // p profit
        // g #gang
        for ((p, g) in profit.zip(group)) {
            for (j in G-g downTo 0) {
                for (i in P downTo maxOf(P-p, 0)) {
                    dp[P][j+g] = (dp[P][j+g] + dp[i][j]) % mod
                }
            }

            for (i in P-1 downTo p) {
                for (j in G downTo g) {
                    dp[i][j] = (dp[i][j] + dp[i-p][j-g]) % mod
                }
            }
        }

        return dp.last().reduce{ a, b -> (a+b) % mod }
    }
}

fun main() {
    println(Solution879().profitableSchemes(5, 3, intArrayOf(2,2), intArrayOf(2,3)))
    println(Solution879().profitableSchemes(10, 5, intArrayOf(2,3,5), intArrayOf(6,7,8)))
}