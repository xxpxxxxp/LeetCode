package com.ypwang.hard

class Solution2416 {
    class Trie {
        var ch = arrayOfNulls<Trie>(26)
        var visited = 0
    }

    fun sumPrefixScores(words: Array<String>): IntArray {
        val trie = Trie()
        val ans = IntArray(words.size)
        for (word in words) {
            var t = trie
            for (c in word) {
                val i = c - 'a'
                if (t.ch[i] == null)
                    t.ch[i] = Trie()

                t.ch[i]!!.visited++
                t = t.ch[i]!!
            }
        }

        for ((k, word) in words.withIndex()) {
            var t = trie
            var curr = 0
            for (c in word) {
                val i = c - 'a'
                curr += t.ch[i]!!.visited
                t = t.ch[i]!!
            }
            ans[k] = curr
        }
        return ans
    }
}
