package com.ypwang.medium

class WordDictionary {
    data class WordTree(val c: Char, var isWord: Boolean, val follow: Array<WordTree?>)

    /** Initialize your data structure here. */
    val root = WordTree('0', false, Array(26){ null })

    /** Adds a word into the data structure. */
    fun addWord(word: String) {
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

    fun search(word: String, root: WordTree): Boolean {
        if (word.isEmpty())
            return root.isWord

        var r = root
        for ((index, c) in word.withIndex()) {
            when (c) {
                '.' -> {
                    return r.follow.filter { it != null }.any{ search(word.substring(index+1), it!!) }
                }
                else -> {
                    val i = c.toInt() - 'a'.toInt()
                    if (r.follow[i] == null) {
                        return false
                    }
                    r = r.follow[i]!!
                }
            }
        }
        return r.isWord
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    fun search(word: String): Boolean = search(word, root)
}

fun main() {
    val w = WordDictionary()
    w.addWord("at")
    w.addWord("and")
    w.addWord("an")
    w.addWord("add")
    w.addWord("bat")
    println(w.search("b."))
    println(w.search("."))
}