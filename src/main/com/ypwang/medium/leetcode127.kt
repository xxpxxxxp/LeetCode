package com.ypwang.medium

class Solution127 {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val map = mutableMapOf<String, MutableSet<String>>()

        for (word in wordList) {
            for (i in 0 until word.length) {
                val t = word.replaceRange(i, i+1, "*")
                if (t !in map) map[t] = mutableSetOf()
                map[t]!!.add(word)
            }
        }

        val visited = mutableSetOf(beginWord)
        var cur = mutableSetOf<String>()
        var step = 2
        for (i in 0 until beginWord.length) {
            val t = beginWord.replaceRange(i, i+1, "*")
            if (t in map) cur.addAll(map[t]!!)
        }

        while (cur.isNotEmpty()) {
            visited.addAll(cur)
            if (endWord in cur)
                return step

            val nextStep = mutableSetOf<String>()

            for (word in cur) {
                for (i in 0 until word.length) {
                    val t = word.replaceRange(i, i+1, "*")
                    for (w in map[t]!!) {
                        if (w !in visited)
                            nextStep.add(w)
                    }
                }
            }

            step++
            cur = nextStep
        }

        return 0
    }
}

fun main() {
    println(Solution127().ladderLength("hit", "cog", listOf("hot","dot","dog","lot","log","cog")))
}