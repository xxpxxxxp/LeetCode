package com.ypwang.hard

class Solution3298 {
    fun validSubstringCount(word1: String, word2: String): Long {
        val counts = IntArray(26)
        for (c in word2)
            counts[c-'a']++

        val window = IntArray(26)

        var i = 0
        var j = 0
        var rst = 0L
        while (j < word1.length) {
            val c = word1[j] - 'a'
            window[c]++

            while (window.zip(counts).all { it.first >= it.second }) {
                rst += word1.length - j
                window[word1[i] - 'a']--
                i++
            }
            j++
        }

        return rst
    }
}

fun main() {
    println(Solution3298().validSubstringCount("eeddeeded", "dde"))
    println(Solution3298().validSubstringCount("dddddededddeeeddd", "eee"))
    println(Solution3298().validSubstringCount("bcca", "abc"))
}