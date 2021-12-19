package com.ypwang.easy

class Solution2108 {
    fun firstPalindrome(words: Array<String>): String =
        words.firstOrNull { it == it.reversed() } ?: ""
}