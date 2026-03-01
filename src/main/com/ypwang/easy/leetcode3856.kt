package com.ypwang.easy

class Solution3856 {
    fun trimTrailingVowels(s: String): String =
        s.dropLastWhile { it in setOf('a', 'e', 'i', 'o', 'u') }
}
