package com.ypwang.medium

class Solution1759 {
    fun countHomogenous(s: String): Int {
        val mod = 1000000007
        var cur = s[0]
        var count = 0L

        var rst = 0L
        for (c in s) {
            if (cur != c) {
                rst = (rst + count * (count + 1) / 2) % mod
                cur = c
                count = 1L
            } else {
                count++
            }
        }

        return ((rst + count * (count + 1) / 2) % mod).toInt()
    }
}