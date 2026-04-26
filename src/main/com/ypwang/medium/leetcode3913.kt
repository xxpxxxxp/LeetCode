package com.ypwang.medium

class Solution3913 {
    fun sortVowels(s: String): String {
        val vowels = Array(5) { intArrayOf(0, Int.MAX_VALUE) }
        val map = mapOf(
            'a' to 0,
            'e' to 1,
            'i' to 2,
            'o' to 3,
            'u' to 4,
        )
        for ((i, c) in s.withIndex()) {
            val idx = map.getOrDefault(c, -1)
            if (idx >= 0) {
                vowels[idx][0]++
                vowels[idx][1] = minOf(i, vowels[idx][1])
            }
        }

        val t = vowels
            .zip(listOf('a', 'e', 'i', 'o', 'u'))
            .sortedWith(compareByDescending<Pair<IntArray, Char>> { it.first[0] }.thenBy { it.first[1] })
            .map { kv -> (0 until kv.first[0]).map { kv.second }.joinToString("") }
            .joinToString("")

        var j = 0
        val ca = CharArray(s.length)
        for ((i, c) in s.withIndex()) {
            if (c in map) {
                ca[i] = t[j]
                j++
            } else {
                ca[i] = c
            }
        }

        return String(ca)
    }
}
