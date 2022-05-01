package com.ypwang.easy

class Solution2255 {
    fun countPrefixes(words: Array<String>, s: String): Int =
        words.count { s.startsWith(it) }
}