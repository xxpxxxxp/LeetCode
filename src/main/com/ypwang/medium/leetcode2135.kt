package com.ypwang.medium

class Solution2135 {
    fun wordCount(startWords: Array<String>, targetWords: Array<String>): Int {
        val seen = startWords.map {
            it.fold(0) { cur, c ->
                cur or (1 shl (c - 'a'))
            }
        }.toSet()

        var rst = 0
        for (word in targetWords) {
            val m = word.fold(0) { cur, c -> cur or (1 shl (c - 'a')) }
            for (c in word) {
                if (m xor (1 shl (c - 'a')) in seen) {
                    rst++
                    break
                }
            }
        }

        return rst
    }
}

fun main() {
    println(Solution2135().wordCount(arrayOf("ant","act","tack"), arrayOf("tack","act","acti")))
}