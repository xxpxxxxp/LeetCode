package com.ypwang.easy

class Solution2788 {
    fun splitWordsBySeparator(words: List<String>, separator: Char): List<String> =
        words.flatMap { it.split(separator) }.filter { it.isNotEmpty() }
}