package com.ypwang.medium

import com.ypwang.WordTree

class Solution648 {
    fun replaceWords(dict: List<String>, sentence: String): String {
        val d = WordTree<String>(' ')
        dict.forEach { d.add(it).attach = it }

        fun helper(s: String): String {
            var r = d
            for (c in s) {
                if (c !in r.subTree) {
                    break
                }
                r = r.subTree[c]!!
                if (r.attach != null) {
                    return r.attach!!
                }
            }
            return s
        }

        return sentence.split(' ').joinToString(" ") { helper(it) }
    }
}

fun main() {
    println(Solution648().replaceWords(listOf("cat", "bat", "rat"), "the cattle was rattled by the battery"))
}