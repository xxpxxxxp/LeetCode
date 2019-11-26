package com.ypwang.hard

import java.lang.StringBuilder

class Solution664 {
    fun strangePrinter(s: String): Int {
        val sb = StringBuilder()
        var m = '\t'
        for (c in s) {
            if (m != c) {
                m = c
                sb.append(m)
            }
        }

        val t = sb.toString()
        if (t.length < 2) return t.length
        val dp = Array(t.length){ IntArray(t.length) }
        for (i in t.indices) {
            dp[i][i] = 1
            if (i < t.lastIndex) {
                dp[i][i+1] = if (t[i] == t[i+1]) 1 else 2
            }
        }

        for (len in 2 until t.length) {
            for (i in 0 until t.length - len) {
                dp[i][i+len] = len+1
                for (j in 0 until len) {
                    val d = dp[i][i+j] + dp[i+j+1][i+len]
                    dp[i][i+len] = minOf(dp[i][i+len], d - if (t[i+j] == t[i+len]) 1 else 0)
                }
            }
        }

        return dp[0].last()
    }
}

fun main() {
    println(Solution664().strangePrinter("hello"))
    println(Solution664().strangePrinter("aaabbb"))
    println(Solution664().strangePrinter("aba"))
}