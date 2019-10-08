package com.ypwang.hard

class Solution902 {
    fun atMostNGivenDigitSet(D: Array<String>, N: Int): Int {
        val s = N.toString()
        val dp = IntArray(s.length+1)
        dp[s.length] = 1
        val d = D.map { it[0] }

        var pow = 1
        for (i in s.lastIndex downTo 0) {
            for (c in d) {
                if (c < s[i])
                    dp[i] += pow
                else if (c == s[i])
                    dp[i] += dp[i + 1]
            }

            pow *= D.size
        }

        pow = D.size
        for (i in 1 until s.length) {
            dp[0] += pow
            pow *= D.size
        }

        return dp[0]
    }
}

fun main() {
    println(Solution902().atMostNGivenDigitSet(arrayOf("1","3","5","7"), 100))
    println(Solution902().atMostNGivenDigitSet(arrayOf("1","4","9"), 1000000000))
}