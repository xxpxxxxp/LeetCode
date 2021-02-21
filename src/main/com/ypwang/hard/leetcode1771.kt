package com.ypwang.hard

class Solution1771 {
    fun longestPalindrome(word1: String, word2: String): Int {
        val str = word1 + word2
        val dp = Array(str.length) { IntArray(str.length) }
        var rst = 0
        for (i in str.indices) {
            dp[i][i] = 1
            if (i > 0) {
                dp[i-1][i] = if (str[i-1] == str[i]) {
                    if (i-1 < word1.length && i >= word1.length)
                        rst = 2

                    2
                } else 1
            }
        }

        for (len in 2 until str.length) {
            for (i in 0 until str.length - len) {
                dp[i][i+len] =
                if (str[i] == str[i+len]) {
                    val v = 2 + dp[i+1][i+len-1]
                    if (i < word1.length && i+len >= word1.length)
                        rst = maxOf(rst, v)

                    v
                }
                else maxOf(dp[i][i+len-1], dp[i+1][i+len])


            }
        }

        return rst
    }
}

fun main() {
    println(Solution1771().longestPalindrome("eeeecd", "eabfbeeb"))
    println(Solution1771().longestPalindrome("aa", "bb"))
    println(Solution1771().longestPalindrome("cacb", "cbba"))
    println(Solution1771().longestPalindrome("ab", "ab"))
}