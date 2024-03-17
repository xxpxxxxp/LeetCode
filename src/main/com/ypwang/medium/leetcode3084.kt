package com.ypwang.medium

class Solution3084 {
    fun countSubstrings(s: String, c: Char): Long {
        val c = s.count { it == c }
        return c.toLong() * (c + 1) / 2
    }
}
