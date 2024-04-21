package com.ypwang.medium

class Solution3131 {
    fun numberOfSpecialChars(word: String): Int =
        word.groupBy { it.lowercaseChar() }
            .map { it.value }
            .count {
                val t = it.toTypedArray()
                it.first().isLowerCase() && it.last().isUpperCase() && (0 until t.lastIndex).all { i -> t[i] >= t[i+1] }
            }
}
