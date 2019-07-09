package com.ypwang.hard

class Solution72 {
    fun minDistance(word1: String, word2: String): Int {
        val dp = IntArray((word1.length + 1) * (word2.length + 1))

        for (i in 0 until word1.length) {
            dp[i+1] = i+1
        }

        for (i in 0 until word2.length) {
            dp[(i+1)*(word1.length+1)] = i+1
        }

        for (j in 0 until word2.length) {
            for (i in 0 until word1.length) {
                dp[(j+1)*(word1.length+1) + i+1] =
                    if (word1[i] == word2[j]) dp[j*(word1.length+1)+i]
                    else 1 + minOf(dp[(j+1)*(word1.length+1)+i], dp[j*(word1.length+1)+i+1], dp[j*(word1.length+1)+i])
            }
        }

        return dp.last()
    }
}

fun main() {
    println(Solution72().minDistance("horse", "ros"))
    println(Solution72().minDistance("intention", "execution"))
}