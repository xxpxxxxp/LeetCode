package com.ypwang.hard

class Solution3045 {
    class TrieNode {
        var children = mutableMapOf<Int, TrieNode>()
        var count: Int = 0
    }

    fun countPrefixSuffixPairs(words: Array<String>): Long {
        val root = TrieNode()
        var res = 0L
        for (word in words) {
            var x = root
            for (i in word.indices) {
                val key = (word[i] - 'a') * 128 + (word[word.length - i - 1] - 'a')
                x = x.children.getOrPut(key) { TrieNode() }
                res += x.count
            }
            x.count++
        }
        return res
    }
}

fun main() {
    println(Solution3045().countPrefixSuffixPairs(Array(100000) { "aaaaa" }))
}