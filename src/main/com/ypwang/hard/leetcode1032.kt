package com.ypwang.hard

class StreamChecker(words: Array<String>) {
    class Trie(val value: Char, var isWord: Boolean) {
        val subTrie = Array<Trie?>(26){null}
    }

    val root = Trie('a', false)

    init {
        for (word in words) {
            var trie = root

            for ((i, c) in word.withIndex()) {
                val idx = c - 'a'
                if (trie.subTrie[idx] == null) trie.subTrie[idx] = Trie(c, false)
                if (i == word.lastIndex) trie.subTrie[idx]!!.isWord = true
                trie = trie.subTrie[idx]!!
            }
        }
    }

    var round = listOf<Trie>()
    fun query(letter: Char): Boolean {
        val idx = letter - 'a'
        val newRound = mutableListOf<Trie>()
        var exist = false

        for (trie in round) {
            if (trie.subTrie[idx] != null) {
                newRound.add(trie.subTrie[idx]!!)

                if (trie.subTrie[idx]!!.isWord)
                    exist = true
            }
        }

        if (root.subTrie[idx] != null) {
            newRound.add(root.subTrie[idx]!!)

            if (root.subTrie[idx]!!.isWord)
                exist = true
        }

        round = newRound
        return exist
    }
}