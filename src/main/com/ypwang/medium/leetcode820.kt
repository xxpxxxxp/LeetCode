package com.ypwang.medium

class Solution820 {
    class Trie {
        val follow: Array<Trie?> = Array(26){null}

        private fun add(word: String, idx: Int) {
            if (idx == word.length) return

            if (follow[word[idx] - 'a'] == null)
                follow[word[idx] - 'a'] = Trie()

            follow[word[idx] - 'a']!!.add(word, idx + 1)
        }

        fun add(word: String) {
            add(word, 0)
        }

        private fun getTotalLen(pre: Int): Int {
            if (follow.all { it == null }) return pre + 1
            return follow.map { it?.getTotalLen(pre + 1) ?: 0 }.sum()
        }

        fun getTotalLen(): Int = getTotalLen(0)
    }

    fun minimumLengthEncoding(words: Array<String>): Int {
        val trie = Trie()
        for (word in words) {
            trie.add(word.reversed())
        }

        return trie.getTotalLen()
    }
}

fun main(args: Array<String>) {
    println(Solution820().minimumLengthEncoding(arrayOf("time", "me", "bell")))
}