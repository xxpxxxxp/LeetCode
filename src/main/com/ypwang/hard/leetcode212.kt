package com.ypwang.hard

class Solution212 {
    class Trie(val cur: Char, var isWord: Boolean = false) {
        val sub = Array<Trie?>(26) { null }
    }

    private fun add(root: Trie, word: String) {
        var head = root
        for ((i, c) in word.withIndex()) {
            val idx = c - 'a'
            if (head.sub[idx] == null) {
                head.sub[idx] = Trie(c, i == word.lastIndex)
            }
            head = head.sub[idx]!!
            if (i == word.lastIndex) {
                head.isWord = true
            }
        }
    }

    private val directions = listOf(-1 to 0, 1 to 0, 0 to 1, 0 to -1)
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        if (board.isEmpty()) return listOf()

        val root = Trie(' ')
        words.forEach { add(root, it) }

        val rst = mutableSetOf<String>()
        val pre = mutableListOf<Char>()     // back trace
        val seen = mutableListOf<Pair<Int, Int>>()

        fun dfs(i: Int, j: Int, r: Trie) {
            val c = board[i][j]
            if (r.sub[c - 'a'] == null) return

            val sub = r.sub[c - 'a']!!
            pre.add(c)
            seen.add(i to j)
            if (sub.isWord) rst.add(pre.joinToString(""))
            for (d in directions) {
                val ii = i + d.first
                val jj = j + d.second
                if (ii in 0 until board.size && jj in 0 until board[0].size && (ii to jj) !in seen) {
                    dfs(ii, jj, sub)
                }
            }

            pre.removeAt(pre.lastIndex)
            seen.remove(i to j)
        }

        for (i in 0 until board.size) {
            for (j in 0 until board[0].size) {
                dfs(i, j, root)
            }
        }
        return rst.toList()
    }
}

fun main() {
    println(Solution212().findWords(listOf("ab", "aa").map { it.toCharArray() }.toTypedArray(),
            arrayOf("aba","baa","bab","aaab","aaa","aaaa","aaba")))
}