package com.ypwang.medium

class Solution1657 {
    fun closeStrings(word1: String, word2: String): Boolean {
        val c1 = IntArray(26)
        val c2 = IntArray(26)

        for (c in word1)
            c1[c - 'a']++

        for (c in word2)
            c2[c - 'a']++

        return c1.withIndex().filter { it.value != 0 }.map { it.index } == c2.withIndex().filter { it.value != 0 }.map { it.index }
                && c1.sorted() == c2.sorted()
    }
}