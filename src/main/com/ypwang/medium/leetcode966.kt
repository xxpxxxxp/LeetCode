package com.ypwang.medium

class Solution966 {
    private val wordsPerfect = mutableSetOf<String>()
    private val wordsCap = mutableMapOf<String, String>()
    private val wordsVow =  mutableMapOf<String, String>()

    fun spellchecker(wordList: Array<String>, queries: Array<String>): Array<String> {
        for (word in wordList) {
            wordsPerfect.add(word)
            val wordLow = word.lowercase()
            wordsCap.putIfAbsent(wordLow, word)
            wordsVow.putIfAbsent(deVowel(wordLow), word)
        }

        return queries.map { solve(it) }.toTypedArray()
    }

    private fun solve(query: String): String {
        if (wordsPerfect.contains(query))
            return query

        val queryL = query.lowercase()
        if (queryL in wordsCap) return wordsCap[queryL]!!

        val queryLV = deVowel(queryL)
        if (queryLV in wordsVow) return wordsVow[queryLV]!!
        return ""
    }

    private fun deVowel(word: String): String = word.map { if (isVowel(it)) '*' else it }.joinToString("")

    private fun isVowel(c: Char): Boolean {
        return c in setOf('a', 'e', 'i', 'o', 'u')
    }
}

fun main() {
    println(Solution966().spellchecker(arrayOf("KiTe","kite","hare","Hare"), arrayOf("kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto")).toList())
}