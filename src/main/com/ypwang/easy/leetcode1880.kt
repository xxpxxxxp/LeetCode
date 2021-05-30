package com.ypwang.easy

class Solution1880 {
    private fun convert(word: String): Int =
        word.map { it - 'a' }.joinToString("").toInt()

    fun isSumEqual(firstWord: String, secondWord: String, targetWord: String): Boolean =
        convert(firstWord) + convert(secondWord) == convert(targetWord)
}