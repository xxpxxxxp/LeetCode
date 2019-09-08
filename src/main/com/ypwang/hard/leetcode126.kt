package com.ypwang.hard

class Solution126 {
    fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
        if (endWord !in wordList) return listOf()

        val words = wordList.toTypedArray()
        val dp = Array(words.size) { BooleanArray(words.size) }
        for (i in words.indices) {
            for (j in i+1 until words.size) {
                val t = words[i].zip(words[j]).count { it.first != it.second } == 1
                dp[i][j] = t
                dp[j][i] = t
            }
        }

        var bfs = mutableListOf<MutableList<Int>>()
        val distance = IntArray(words.size){Int.MAX_VALUE}
        for (i in words.indices) {
            if (beginWord.zip(words[i]).count { it.first != it.second } == 1) {
                if (words[i] == endWord) return listOf(listOf(beginWord, endWord))

                bfs.add(mutableListOf(i))
                distance[i] = 1
            }
        }

        var dis = 1
        while (bfs.isNotEmpty()) {
            dis++
            val next = mutableListOf<MutableList<Int>>()
            var exist = false

            for (pre in bfs) {
                for (i in words.indices) {
                    if (dp[pre.last()][i] && dis <= distance[i]) {
                        if (words[i] == endWord) exist = true

                        distance[i] = dis
                        val t = pre.toMutableList()
                        t.add(i)
                        next.add(t)
                    }
                }
            }

            bfs = next
            if (exist) break
        }

        return bfs.filter { words[it.last()] == endWord }.map { listOf(beginWord) + it.map { i -> words[i] } }
    }
}

fun main() {
    println(Solution126().findLadders("a", "c", listOf("a", "b", "c")))
}