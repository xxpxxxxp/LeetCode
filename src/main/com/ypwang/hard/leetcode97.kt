package com.ypwang.hard

class Solution97 {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        if (s1.length + s2.length != s3.length) return false

        val dp = BooleanArray((s1.length+1) * (s2.length+1))
        dp[0] = true

        for (i in 0 until s1.length) {
            dp[i+1] = dp[i] && s1[i] == s3[i]
        }

        for (i in 0 until s2.length) {
            dp[(i+1) * (s1.length+1)] = dp[i * (s1.length+1)] && s2[i] == s3[i]
        }

        for (i in 0 until s2.length) {
            for (j in 0 until s1.length) {
                var v = false

                if (dp[i * (s1.length+1) + j+1] && s2[i] == s3[i+j+1])
                    v = true

                if (!v && dp[(i+1) * (s1.length+1) + j] && s1[j] == s3[i+j+1])
                    v = true

                dp[(i+1) * (s1.length+1) + j+1] = v
            }
        }

        return dp.last()
    }
}

fun main() {
    println(Solution97().isInterleave("aabcc", "dbbca", "aadbbcbcac"))
}