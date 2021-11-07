package com.ypwang.medium

class Solution2063 {
    fun countVowels(word: String): Long {
        val size = word.length

        return word.withIndex().map { (i, c) ->
            if (c in setOf('a', 'e', 'i', 'o', 'u')) {
                (i + 1L) * (size - i)
            } else
                0L
        }.sum()
    }
}