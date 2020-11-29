package com.ypwang.medium

class Solution5 {
    fun longestPalindrome(s: String): String {
        val len = s.length
        if (len < 2) {
            return s
        }

        fun pos(m: Int, n: Int): Int = (2*len - m - 1) * m / 2 + n

        val buf = Array(pos(len - 1, len - 1) + 1){false}

        var start = 0
        var end = 0

        for (i in 0 until len) {
            buf[pos(i, i)] = true

            if (i+1 < len) {
                if (s[i] == s[i+1]) {
                    buf[pos(i, i+1)] = true
                    start = i
                    end = i+1
                }
            }
        }

        for (c in 2 until len) {
            for (i in 0 until len - c) {
                val t = if (s[i] == s[i+c]) buf[pos(i+1, i+c-1)] else false
                buf[pos(i, i+c)] = t
                if (t) {
                    start = i
                    end = i+c
                }
            }
        }

        return s.substring(start, end + 1)
    }
}

fun main() {
    println(Solution5().longestPalindrome("abcda"))
}