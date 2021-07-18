package com.ypwang.easy

class Solution1935 {
    fun canBeTypedWords(text: String, brokenLetters: String): Int {
        val broken = brokenLetters.toSet()
        return text.split(' ').count { it.all { c -> c !in broken } }
    }
}