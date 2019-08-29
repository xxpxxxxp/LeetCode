package com.ypwang.easy

class Solution1160 {
    private fun count(s: String): IntArray {
        val a = IntArray(26)
        for (c in s) {
            a[c-'a']++
        }
        return a
    }

    fun countCharacters(words: Array<String>, chars: String): Int {
        val base = count(chars)
        return words.filter { count(it).zip(base).all { p -> p.first <= p.second } }.sumBy { it.length }
    }
}