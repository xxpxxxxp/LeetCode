package com.ypwang.medium

class Solution2311 {
    fun longestSubsequence(s: String, k: Int): Int {
        var n = 0
        var cnt = 0
        var pow = 1
        var i = s.lastIndex
        while (i >= 0 && n + pow <= k) {
            if (s[i] == '1') {
                ++cnt
                n += pow
            }
            pow *= 2
            --i
        }
        return s.count { it == '0' } + cnt
    }
}

fun main() {
    println(Solution2311().longestSubsequence("1001010", 5))
}