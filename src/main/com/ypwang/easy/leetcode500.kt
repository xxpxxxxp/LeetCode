package com.ypwang.easy

class Solution500 {
    fun findWords(words: Array<String>): Array<String> {
        fun mapC(c: Char): Int {
            return when(c.lowercase()) {
                in "qwertyuiop" -> 1
                in "asdfghjkl" -> 2
                in "zxcvbnm" -> 3
                else -> 4
            }
        }
        return words.filter { s -> s.map { mapC(it) }.toSet().count() == 1 }.toTypedArray()
    }
}
