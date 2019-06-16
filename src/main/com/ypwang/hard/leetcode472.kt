package com.ypwang.hard

class Solution472 {
    class Trie(val cur: Char, var isWord: Boolean = false) {
        val sub = Array<Trie?>(26) { null }
    }

    fun findAllConcatenatedWordsInADict(words: Array<String>): List<String> {
        words.sortBy { it.length }

        val rst = mutableListOf<String>()
        val root = Trie(' ')

        for (word in words) {
            if (isConcat(root, word, false)) rst.add(word)
            add(root, word)
        }

        return rst
    }

    fun isConcat(root: Trie, word: String, flag: Boolean): Boolean {
        var head = root
        for ((i, c) in word.withIndex()) {
            val idx = c - 'a'
            if (head.sub[idx] == null) return false

            head = head.sub[idx]!!
            if (i == word.lastIndex) return head.isWord && flag
            if (head.isWord && isConcat(root, word.substring(i+1), true)) return true
        }

        return false
    }

    fun add(root: Trie, word: String) {
        var head = root
        for ((i, c) in word.withIndex()) {
            val idx = c - 'a'
            if (head.sub[idx] == null) {
                head.sub[idx] = Trie(c, i == word.lastIndex)
            }
            head = head.sub[idx]!!
        }
    }
}

fun main() {
    println(Solution472().findAllConcatenatedWordsInADict(arrayOf("cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat")))
}