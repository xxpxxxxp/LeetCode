package com.ypwang.easy

class Solution3813 {
    fun vowelConsonantScore(s: String): Int {
        val vowels = s.count { it in setOf('a', 'e', 'i', 'o', 'u') }
        val c = s.count { it.isLetter() } - vowels
        return if (c == 0) 0 else Math.floor(vowels.toDouble() / c).toInt()
    }
}
