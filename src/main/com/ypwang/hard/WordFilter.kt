package com.ypwang.hard

class WordFilter(words: Array<String>) {
    data class Trie(var weight: Int = 0, val children: Array<Trie?> = Array(27){null})

    val root = Trie(-1)
    init {
        for ((weight, w) in words.withIndex()) {
            val word = "$w{"        // because '{' = 'z' + 1
            for (i in word.indices) {
                var cur = root
                for (j in i until 2 * word.length - 1) {
                    val k = word[j % word.length] - 'a'
                    if (cur.children[k] == null) cur.children[k] = Trie(weight)
                    cur = cur.children[k]!!
                    cur.weight = weight
                }
            }
        }
    }

    fun f(prefix: String, suffix: String): Int {
        var cur = root
        for (c in "$suffix{$prefix") {
            val k = c - 'a'
            if (cur.children[k] == null) return -1
            cur = cur.children[k]!!
        }

        return cur.weight
    }
}