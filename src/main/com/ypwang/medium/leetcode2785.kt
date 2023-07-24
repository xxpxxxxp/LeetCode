package com.ypwang.medium

class Solution2785 {
    fun sortVowels(s: String): String {
        val vowels = "AEIOUaeiou".toSet()
        val index = s.withIndex().filter { it.value in vowels }.map { it.index }
        val sorted = index.map { s[it] }.sorted()
        val cs = s.toCharArray()
        index.zip(sorted).map { cs[it.first] = it.second }
        return String(cs)
    }
}