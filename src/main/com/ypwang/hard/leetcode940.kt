package com.ypwang.hard

class Solution940 {
    fun distinctSubseqII(S: String): Int {
        val mod = 1000000007
        val dp = IntArray(S.length+1){1}

        val last = IntArray(26){-1}

        for ((i, c) in S.withIndex()) {
            val cur = c - 'a'
            dp[i+1] = (2 * dp[i]) % mod
            if (last[cur] >= 0) {
                dp[i+1] -= dp[last[cur]]
            }
            dp[i+1] %= mod
            last[cur] = i
        }

        dp[S.length]--
        return if (dp.last() < 0) dp.last() + mod else dp.last()
    }
}

fun main() {
    println(Solution940().distinctSubseqII("abc"))
    println(Solution940().distinctSubseqII("aba"))
    println(Solution940().distinctSubseqII("aaa"))
}