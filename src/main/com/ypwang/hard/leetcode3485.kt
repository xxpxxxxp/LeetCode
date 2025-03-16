package com.ypwang.hard

class Solution3485 {
    class TrieNode {
        val children = arrayOfNulls<TrieNode>(26)
        var count = 0
        var bestPrefixLength = -1
    }

    fun longestCommonPrefix(words: Array<String>, k: Int): IntArray {
        val totalWords = words.size
        val result = IntArray(totalWords)
        if (totalWords - 1 < k)
            return result

        val root = TrieNode()

        fun updateTrie(word: String, count: Int) {
            val wordLength = word.length
            // used to store the path used during trie traversal to update the count and use the count
            val nodePath = arrayOfNulls<TrieNode>(wordLength + 1)
            val depths = IntArray(wordLength + 1)
            nodePath[0] = root
            depths[0] = 0
            // trie insertion
            for (i in 0 until wordLength) {
                val letterIndex = word[i] - 'a'
                if (nodePath[i]?.children?.get(letterIndex) == null) {
                    nodePath[i]?.children?.set(letterIndex, TrieNode())
                }
                nodePath[i + 1] = nodePath[i]?.children?.get(letterIndex)
                depths[i + 1] = depths[i] + 1
            }
            // increase the count of each prefix
            for (node in nodePath)
                node?.count = node.count + count

            // find the best prefix
            for (i in nodePath.size - 1 downTo 0) {
                val currentNode = nodePath[i]
                var candidate = if ((currentNode?.count ?: 0) >= k) depths[i] else -1
                candidate = maxOf(candidate, currentNode?.children?.maxOfOrNull { it?.bestPrefixLength ?: -1 } ?: -1)
                currentNode?.bestPrefixLength = candidate
            }
        }

        //insert the word with increasing the count by 1 (prefix count)
        words.forEach { updateTrie(it, 1) }

        for (i in 0 until totalWords) {
            //temp deletion of the word with count decreased by 1
            updateTrie(words[i], -1)
            result[i] = root.bestPrefixLength
            //re-insertion of the word
            updateTrie(words[i], 1)
        }
        return result
    }
}
