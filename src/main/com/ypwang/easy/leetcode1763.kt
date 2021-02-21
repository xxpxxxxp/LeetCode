package com.ypwang.easy

class Solution1763 {
    fun longestNiceSubstring(s: String): String {
        if (s.length < 2)
            return ""

        val set = s.toSet()
        for ((i, c) in s.withIndex()) {
            if (!set.contains(c.toUpperCase()) || !set.contains(c.toLowerCase())) {
                val sub1 = longestNiceSubstring(s.substring(0, i))
                val sub2 = longestNiceSubstring(s.substring(i + 1))
                return if (sub1.length >= sub2.length) sub1 else sub2
            }
        }

        return s
    }
}