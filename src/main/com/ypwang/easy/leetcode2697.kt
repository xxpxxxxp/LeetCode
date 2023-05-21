package com.ypwang.easy

class Solution2697 {
    fun makeSmallestPalindrome(s: String): String {
        val cs = s.toCharArray()
        for (i in 0 until s.length / 2) {
            if (cs[i] != cs[s.lastIndex-i]) {
                val c = minOf(cs[i], cs[s.lastIndex-i])
                cs[i] = c
                cs[s.lastIndex-i] = c
            }
        }
        return String(cs)
    }
}