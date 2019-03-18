package com.ypwang.medium

class Trie() {
    data class WordTree(val c: Char, var isWord: Boolean, val follow: Array<WordTree?>)

    /** Initialize your data structure here. */
    val root = WordTree('0', false, Array(26){ null })

    /** Inserts a word into the trie. */
    fun insert(word: String) {
        var r = root
        for ((index, c) in word.withIndex()) {
            val i = c.toInt() - 'a'.toInt()
            if (r.follow[i] == null) {
                r.follow[i] = WordTree(c, false, Array(26) { null })
            }
            r = r.follow[i]!!
            if (index == word.lastIndex) {
                r.isWord = true
            }
        }
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        if (word.isEmpty())
            return true

        var r = root
        for (c in word) {
            val i = c.toInt() - 'a'.toInt()
            if (r.follow[i] == null) {
                return false
            }
            r = r.follow[i]!!
        }
        return r.isWord
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        if (prefix.isEmpty())
            return true

        var r = root
        for (c in prefix) {
            val i = c.toInt() - 'a'.toInt()
            if (r.follow[i] == null) {
                return false
            }
            r = r.follow[i]!!
        }
        return true
    }
}