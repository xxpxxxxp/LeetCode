package com.ypwang.medium

class Solution2559 {
    fun vowelStrings(words: Array<String>, queries: Array<IntArray>): IntArray {
        val vowels = "aeiouAEIOU".toSet()
        val prefix = IntArray(words.size+1)
        for ((i, word) in words.withIndex()) {
            prefix[i+1] = prefix[i]
            if (word.first() in vowels && word.last() in vowels)
                prefix[i+1]++
        }

        return queries.map { (s, e) -> prefix[e+1] - prefix[s] }.toIntArray()
    }
}

fun main() {
    println(Solution2559().vowelStrings(arrayOf("aba","bcb","ece","aa","e"), arrayOf(intArrayOf(0, 2))).toList())
}