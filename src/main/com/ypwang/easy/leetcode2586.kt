package com.ypwang.easy

class Solution2586 {
    fun vowelStrings(words: Array<String>, left: Int, right: Int): Int =
        (left..right).map { words[it] }.count { it.first() in setOf('a', 'e', 'i', 'o', 'u') && it.last() in setOf('a', 'e', 'i', 'o', 'u') }
}