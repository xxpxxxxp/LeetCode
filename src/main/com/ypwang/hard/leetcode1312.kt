package com.ypwang.hard

class Solution1312 {
    fun minInsertions(s: String): Int {
        val dp = Array(s.length+1){ IntArray(s.length+1) }

        for (i in s.indices) {
            for (j in s.indices) {
                dp[i+1][j+1] = maxOf(dp[i][j+1], dp[i+1][j])
                if (s[i] == s[s.length-j-1])
                    dp[i+1][j+1] = maxOf(dp[i+1][j+1], 1 + dp[i][j])
            }
        }

        return s.length - dp.last().last()
    }
}

fun main() {
    println(Solution1312().minInsertions("zzazz"))
    println(Solution1312().minInsertions("mbadm"))
    println(Solution1312().minInsertions("leetcode"))
    println(Solution1312().minInsertions("g"))
    println(Solution1312().minInsertions("no"))
}