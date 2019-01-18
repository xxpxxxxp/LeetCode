package com.ypwang

class WordTree<A>(val `val`: Char) {
    val subTree: MutableMap<Char, WordTree<A>> = mutableMapOf()
    var attach: A? = null

    fun add(word: String): WordTree<A> {
        if (word.isEmpty()) {
            return this
        }

        val c = word.first()
        if (c !in subTree) {
            subTree[c] = WordTree(c)
        }
        return subTree[c]!!.add(word.drop(1))
    }

    fun getRoot(word: String): WordTree<A>? {
        if (word.isEmpty()) {
            return this
        }
        val c = word.first()
        if (c in subTree) {
            return subTree[c]!!.getRoot(word.drop(1))
        }
        return null
    }
}