package com.ypwang.medium

class Solution2131 {
    fun longestPalindrome(words: Array<String>): Int {
        val c = words.groupBy { it }.mapValues { it.value.size }.toMutableMap()
        var rst = 0
        var odd = false

        for ((i, v) in c) {
            if (i == i.reversed()) {
                rst += v / 2
                if (v % 2 > 0)
                    odd = true
            } else if (i.reversed() in c) {
                val m = minOf(v, c[i.reversed()]!!)
                c[i] = v - m
                c[i.reversed()] = c[i.reversed()]!! - m
                rst += m
            }
        }

        return rst * 4 + if (odd) 2 else 0
    }
}