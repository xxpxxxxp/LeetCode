package com.ypwang.hard

class Solution132 {
    fun minCut(s: String): Int {
        val dp = Array(s.length){ BooleanArray(s.length) }

        for (i in s.indices) {
            dp[i][i] = true
            if (i > 0 && s[i-1] == s[i]) dp[i-1][i] = true
        }

        for (diff in 2 until s.length) {
            for (i in diff until s.length) {
                if (dp[i-diff+1][i-1] && s[i] == s[i-diff]) dp[i-diff][i] = true
            }
        }

        val distMap = mutableMapOf<Int, Int>()
        for (i in s.indices) {
            if (dp[0][i]) distMap[i+1] = 1
        }

        while (s.length !in distMap) {
            val (next, step) = distMap.minByOrNull { it.value }!!
            for (i in next until s.length) {
                if (dp[next][i]) {
                    if (i+1 !in distMap || distMap[i+1]!! > step+1) {
                        distMap[i+1] = step+1
                    }
                }
            }
            distMap.remove(next)
        }

        return distMap[s.length]!! - 1
    }
}

fun main() {
    println(Solution132().minCut("aab"))
}