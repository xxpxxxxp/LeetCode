package com.ypwang.hard

class Solution10 {
    fun isMatch(s: String, p: String): Boolean {
        val dp = Array(p.length + 1) { BooleanArray(s.length + 1) }
        dp[0][0] = true

        for ((i, pc) in p.withIndex()) {
            var fit = false
            for ((j, sc) in s.withIndex()) {
                if (dp[i][j]) fit = true
                dp[i+1][j+1] = when (pc) {
                    '.' -> dp[i][j]
                    '*' -> fit
                    else -> dp[i][j] && pc == sc
                }
            }
        }

        return dp.last().last()
    }
}

fun main() {
    println(Solution10().isMatch("aa", "a"))
    println(Solution10().isMatch("aa", "a*"))
    println(Solution10().isMatch("ab", ".*"))
    println(Solution10().isMatch("aab", "c*a*b"))
    println(Solution10().isMatch("mississippi", "mis*is.*p*."))
    println(Solution10().isMatch("a", ""))
    println(Solution10().isMatch("a", "aa"))
}