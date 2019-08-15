package com.ypwang.hard

class Solution115 {
    fun numDistinct(s: String, t: String): Int {
        val dp = IntArray((s.length+1) * (t.length+1))

        for (i in 0..s.length) {
            dp[i] = 1
        }

        for (i in 0 until t.length) {
            var tmp = 0
            for (j in 0 until s.length) {
                if (t[i] == s[j]) tmp += dp[i*(s.length+1)+j]
                dp[(i+1)*(s.length+1)+j+1] = tmp
            }
        }

        return dp.last()
    }
}

fun main() {
    println(Solution115().numDistinct("rabbbit", "rabbit"))
    println(Solution115().numDistinct("babgbag", "bag"))
}