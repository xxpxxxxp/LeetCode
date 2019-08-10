package com.ypwang.hard

class Solution44 {
    fun isMatch(s: String, p: String): Boolean {
        val dp = BooleanArray((s.length+1)*(p.length+1))
        dp[0] = true
        for (i in 1..p.length) {
            if (p[i-1] == '*')
                dp[i] = dp[i-1]
        }

        for (i in 1..p.length) {
            for (j in 1..s.length) {
                dp[j * (p.length + 1) + i] =
                    when (p[i - 1]) {
                        in 'a'..'z' -> p[i - 1] == s[j - 1] && dp[(j - 1) * (p.length + 1) + i - 1]
                        '?' -> dp[(j - 1) * (p.length + 1) + i - 1]
                        '*' -> dp[(j - 1) * (p.length + 1) + i - 1] || dp[j * (p.length + 1) + i - 1] || dp[(j - 1) * (p.length + 1) + i]
                        else -> false
                    }
            }
        }

        return dp.last()
    }
}

fun main() {
    println(Solution44().isMatch("a", "a*"))
    println(Solution44().isMatch("aa", "a"))
    println(Solution44().isMatch("aa", "*"))
    println(Solution44().isMatch("cb", "?a"))
    println(Solution44().isMatch("adceb", "*a*b"))
    println(Solution44().isMatch("acdcb", "a*c?b"))
}