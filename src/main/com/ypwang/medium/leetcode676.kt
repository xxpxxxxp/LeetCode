package com.ypwang.medium

import com.ypwang.WordTree

class MagicDictionary {

    /** Initialize your data structure here. */
    val root = WordTree<Boolean>(' ')

    /** Build a dictionary through a list of words */
    fun buildDict(dict: Array<String>) {
        dict.forEach { root.add(it).attach = true }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    fun search(word: String): Boolean {
        fun helper(word: String, r: WordTree<Boolean>, allow1: Boolean): Boolean {
            val c = word.first()
            val next = word.drop(1)
            if (next.isEmpty()) {
                return (!allow1 && c in r.subTree && r.subTree[c]!!.attach == true) || (allow1 && r.subTree.any { it.key != c && it.value.attach == true })
            }

            return (c in r.subTree && helper(next, r.subTree[c]!!, allow1))
                    || (allow1 && r.subTree.any { it.key != c && helper(next, it.value, false) })
        }

        if (word.isEmpty()) {
            return false
        }
        return helper(word, root, true)
    }
}

fun main() {
    val t = MagicDictionary()
    t.buildDict(arrayOf("hello", "leetcode"))
    println(t.search("hello"))
    println(t.search("hhllo"))
    println(t.search("hell"))
    println(t.search("leetcoded"))
}