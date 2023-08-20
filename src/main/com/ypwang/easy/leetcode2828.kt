package com.ypwang.easy

class Solution2828 {
    fun isAcronym(words: List<String>, s: String): Boolean =
        words.joinToString("") { it.first().toString() } == s
}