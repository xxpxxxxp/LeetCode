package com.ypwang.hard

import java.lang.StringBuilder

class Solution140 {
    data class WordTree(val c: Char, var isWord: Boolean, val follow: Array<WordTree?>)

    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        val root = WordTree('0', false, Array(26){ null })

        fun insert(word: String) {
            var r = root
            for ((index, c) in word.withIndex()) {
                val i = c.toInt() - 'a'.toInt()
                if (r.follow[i] == null) {
                    r.follow[i] = WordTree(c, false, Array(26) { null })
                }
                r = r.follow[i]!!
                if (index == word.lastIndex) {
                    r.isWord = true
                }
            }
        }

        wordDict.forEach { insert(it) }

        val dp = Array<MutableList<Int>?>(s.length+1){ null }
        dp[0] = mutableListOf()

        for (i in s.indices) {
            if (dp[i] != null) {
                // it's possible to generate from here, iterate tree
                var j = i
                var r = root
                while (j < s.length && r.follow[s[j] - 'a'] != null) {
                    r = r.follow[s[j] - 'a']!!
                    if (r.isWord) {
                        if (dp[j+1] == null) dp[j+1] = mutableListOf()
                        dp[j+1]!!.add(i)
                    }
                    j++
                }
            }
        }

        val rst = mutableListOf<String>()
        val breakPoints = ArrayList<Int>()
        fun breakString(bp: List<Int>) {
            if (bp.isEmpty()) {
                // output
                val sb = StringBuilder()
                for (i in breakPoints.lastIndex downTo 1) {
                    sb.append(s.substring(breakPoints[i], breakPoints[i-1]))
                    sb.append(' ')
                }
                sb.append(s.substring(breakPoints[0]))
                rst.add(sb.toString())
            }

            for (p in bp) {
                breakPoints.add(p)
                breakString(dp[p]!!)
                breakPoints.removeAt(breakPoints.lastIndex)
            }
        }

        if (dp.last() == null) return rst
        breakString(dp.last()!!)
        return rst
    }
}

fun main() {
    println(Solution140().wordBreak("catsandog", listOf("cats", "dog", "sand", "and", "cat")))
}