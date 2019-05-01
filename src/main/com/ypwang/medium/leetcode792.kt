package com.ypwang.medium

class Solution792 {
    fun numMatchingSubseq(S: String, words: Array<String>): Int {
        val s = S.withIndex().groupBy { it.value }.mapValues { it.value.map { i -> i.index }.toIntArray() }
        return words.count { word ->
            var cur = -1
            for (c in word) {
                if (c !in s) return@count false
                val dict = s.getValue(c)
                val t = dict.binarySearch(cur).let { if (it < 0) -it - 1 else it + 1 }
                if (t == dict.size) return@count false
                cur = dict[t]
            }
            true
        }
    }
}

fun main() {
    println(Solution792().numMatchingSubseq("abcde", arrayOf("a", "bb", "acd", "ace")))
}