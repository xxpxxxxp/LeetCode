package com.ypwang.medium

class Solution3106 {
    fun getSmallestString(s: String, k: Int): String {
        var count = k
        val rst = s.toCharArray()

        for ((i, c) in rst.withIndex()) {
            val n = c - 'a'
            if (n <= count || n + count >= 26) {
                rst[i] = 'a'
                count -= minOf(n, 26 - n)
            } else {
                rst[i] = 'a' + (n - count)
                break
            }
        }

        return String(rst)
    }
}
