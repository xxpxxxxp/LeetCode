package com.ypwang.hard

class Solution1255 {
    fun maxScoreWords(words: Array<String>, letters: CharArray, score: IntArray): Int {
        val count = IntArray(26)
        for (c in letters) count[c-'a']++

        fun generate(idx: Int, occurrence: IntArray, pre: Int): Int {
            if (idx == words.size) return pre
            val clone = occurrence.clone().apply { words[idx].forEach { c -> this[c-'a']-- } }
            var next = generate(idx+1, occurrence, pre)
            if (clone.all { it >= 0 }) {
                next = maxOf(next, generate(idx+1, clone, pre + words[idx].sumBy { score[it-'a'] }))
            }

            return next
        }

        return generate(0, count, 0)
    }
}

fun main() {
    println(Solution1255().maxScoreWords(arrayOf("dog","cat","dad","good"), charArrayOf('a','a','c','d','d','d','g','o','o'),
            intArrayOf(1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0)))
    println(Solution1255().maxScoreWords(arrayOf("xxxz","ax","bx","cx"), charArrayOf('z','a','b','c','x','x','x'),
            intArrayOf(4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10)))
    println(Solution1255().maxScoreWords(arrayOf("leetcode"), charArrayOf('l','e','t','c','o','d'),
            intArrayOf(0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0)))
}