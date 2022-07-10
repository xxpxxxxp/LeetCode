package com.ypwang.hard

import java.math.BigInteger

class Solution2338 {
    fun idealArrays(n: Int, maxValue: Int): Int {
        val mod = 1000000007
        val dp = Array(15) { LongArray(maxValue + 1) }
        val map = buildMap(maxValue)

        // step 1: compute dp for the alternative problem (strictly increasing case)
        for (i in 1..maxValue)
            dp[1][i] = 1L

        for (i in 2..minOf(n, 14))
            for (j in 1..maxValue)
                for (k in map.getOrDefault(j, mutableListOf()))
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % mod

        for (i in 1..minOf(n, 14))
            for (j in 1..maxValue) {
                dp[i][0] = (dp[i][0] + dp[i][j]) % mod // dp[i][0] = number of ideal arrays (strictly increasing case) of length i
            }

        // step 2: use combinatorics to get the final answer for the actual problem from the alternative problem (strictly increasing case)
        var res = BigInteger.ZERO
        for (i in 1..minOf(n, 14))
            res = res.add(nCk(n - 1, i - 1).multiply(BigInteger.valueOf(dp[i][0]))).mod(BigInteger.valueOf(mod.toLong()))

        return res.toInt()
    }

    // helper function to compute "n choose k"
    private fun nCk(n: Int, k: Int): BigInteger {
        var res = BigInteger.ONE
        for (i in 1..k) {
            res = res.multiply(BigInteger.valueOf((n - (i - 1)).toLong())).divide(BigInteger.valueOf(i.toLong()))
        }
        return res
    }

    // helper funciton to build map {Integer -> {its divisors}}
    private fun buildMap(maxValue: Int): Map<Int, MutableList<Int>> {
        val map = mutableMapOf<Int, MutableList<Int>>()
        for (i in 1..maxValue) {
            var j = i * 2 // strictly increasing
            while (j <= maxValue) {
                map.getOrPut(j) { mutableListOf() }.add(i)
                j += i
            }
        }
        return map
    }
}