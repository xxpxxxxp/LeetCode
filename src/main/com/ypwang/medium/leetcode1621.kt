package com.ypwang.medium

class Solution1621 {
    fun numberOfSets(n: Int, k: Int): Int {
        val mod = 1000000007
        val dp = Array(n){ IntArray(k+1) }

        for (i in dp.indices)
            dp[i][0] = 1

        for (j in 1..k) {
            var sum = 0
            for (i in n-1 downTo 0) {
                if (i+1 < n)
                    dp[i][j] = (sum + dp[i+1][j]) % mod
                sum = (sum + dp[i][j-1]) % mod
            }
        }

        return dp[0][k]
    }
}

fun main() {
    println(Solution1621().numberOfSets(4,2))
    println(Solution1621().numberOfSets(3,1))
    println(Solution1621().numberOfSets(30,7))
    println(Solution1621().numberOfSets(5,3))
    println(Solution1621().numberOfSets(3,2))
}