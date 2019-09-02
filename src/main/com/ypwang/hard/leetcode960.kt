package com.ypwang.hard

class Solution960 {
    fun minDeletionSize(A: Array<String>): Int {
        val dp = IntArray(A[0].length){1}
        var max = 1
        for (i in 1 until A[0].length) {
            for (j in i-1 downTo 0) {
                if (A.all { it[i] >= it[j] } && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1
                }
            }

            if (dp[i] > max) max = dp[i]
        }

        return A[0].length - max
    }
}

fun main() {
    println(Solution960().minDeletionSize(arrayOf("abbba")))
    println(Solution960().minDeletionSize(arrayOf("babca","bbazb")))
    println(Solution960().minDeletionSize(arrayOf("ghi","def","abc")))
}