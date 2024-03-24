package com.ypwang.hard

class Solution3093 {
    class TrieNode {
        private val children = Array<TrieNode?>(26) { null }
        private var minSz = Int.MAX_VALUE
        private var bestI = 0

        fun insert(word: String, i: Int, j: Int) {
            if (minSz > word.length) {
                bestI = i
                minSz = word.length
            }
            if (j < 0)
                return
            if (children[word[j] - 'a'] == null)
                children[word[j] - 'a'] = TrieNode()

            children[word[j] - 'a']!!.insert(word, i, j - 1)
        }

        fun find(query: String, j: Int): Int {
            if (j >= 0 && children[query[j] - 'a'] != null)
                return children[query[j] - 'a']!!.find(query, j - 1)

            return bestI
        }
    }

    fun stringIndices(wordsContainer: Array<String>, wordsQuery: Array<String>): IntArray {
        val t = TrieNode()
        for ((i, word) in wordsContainer.withIndex())
            t.insert(word, i, word.lastIndex)

        val rst = IntArray(wordsQuery.size)
        for ((i, q) in wordsQuery.withIndex())
            rst[i] = t.find(q, q.lastIndex)
        return rst
    }
}
