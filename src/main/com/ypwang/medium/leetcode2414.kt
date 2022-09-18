package com.ypwang.medium

class Solution2414 {
    fun longestContinuousSubstring(s: String): Int {
        var rst = 0
        var count = 0
        var p = s[0] - 1
        for (c in s) {
            if (c - p == 1)
                count++
            else {
                rst = maxOf(rst, count)
                count = 1
            }
            p = c
        }

        return maxOf(rst, count)
    }
}

fun main() {
    println(Solution2414().longestContinuousSubstring("abacaba"))
}