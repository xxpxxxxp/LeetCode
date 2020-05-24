package com.ypwang.easy

class Solution1455 {
    fun isPrefixOfWord(sentence: String, searchWord: String): Int =
            1 + (sentence.split(" ").filter { it.isNotEmpty() }.withIndex().firstOrNull { it.value.startsWith(searchWord) }?.index ?: -2)
}