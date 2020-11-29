package com.ypwang.medium

class Solution139 {
    data class WordTree(val c: Char, var isWord: Boolean, val follow: Array<WordTree?>)

    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val cache = mutableMapOf<String, Boolean>()
        val root = WordTree('\n', false, Array(26){ null })

        for (word in wordDict) {
            var r = root
            for ((index, c) in word.withIndex()) {
                val i = c.toInt() - 'a'.toInt()
                if (r.follow[i] == null) {
                    r.follow[i] = WordTree(c, false, Array(26){ null })
                }
                r = r.follow[i]!!
                if (index == word.lastIndex) {
                    r.isWord = true
                }
            }
        }

        fun exist(word: String): Boolean {
            if (word.isEmpty())
                return true

            if (word in cache)
                return cache[word]!!

            var r = root
            for ((index, c) in word.withIndex()) {
                val i = c.toInt() - 'a'.toInt()
                if (r.follow[i] != null) {
                    if (r.follow[i]!!.isWord && exist(word.substring(index + 1))) {
                        cache[word] = true
                        return true
                    }
                    r = r.follow[i]!!
                } else {
                    cache[word] = false
                    return false
                }
            }

            cache[word] = false
            return false
        }

        return exist(s)
    }
}

fun main() {
    println(Solution139().wordBreak("catsandog", listOf("cats", "dog", "sand", "and", "cat")))
}