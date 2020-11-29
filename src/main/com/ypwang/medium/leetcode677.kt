package com.ypwang.medium

import com.ypwang.WordTree

class MapSum {

    /** Initialize your data structure here. */
    val root = WordTree<Int>(' ')

    fun insert(key: String, `val`: Int) {
        root.add(key).attach = `val`
    }

    fun helper(wordTree: WordTree<Int>): Int {
        return (wordTree.attach ?: 0) + wordTree.subTree.map { it.value }.sumBy { helper(it) }
    }

    fun sum(prefix: String): Int {
        val r = root.getRoot(prefix) ?: return 0
        return helper(r)
    }
}

fun main() {
    val t = MapSum()
    t.insert("apple", 3)
    println(t.sum("apple"))
    t.insert("app", 2)
    println(t.sum("ap"))
}