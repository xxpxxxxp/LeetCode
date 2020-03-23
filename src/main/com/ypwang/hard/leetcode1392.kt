package com.ypwang.hard

class Solution1392 {
    fun longestPrefix(s: String): String {
        val mod = 1000000007
        var hashf = 0L
        var hashl = 0L
        var mul = 1L
        var len = -1
        for (i in 0 until s.lastIndex) {
            hashf = (hashf * 26 + (s[i] - 'a')) % mod
            hashl = (hashl + (s[s.lastIndex - i] - 'a') * mul) % mod
            mul = (mul * 26) % mod
            if (hashf == hashl)
                len = i
        }

        return s.substring(0, len + 1)
    }
}

fun main() {
    println(Solution1392().longestPrefix("abcdabcdabcdabcd"))
}