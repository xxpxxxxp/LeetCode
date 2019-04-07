package com.ypwang.medium

class Solution395 {
    fun longestSubstring(s: String, k: Int): Int {
        val c = s.groupBy { it }.mapValues { it.value.size }
        if (c.all { it.value >= k })
            return s.length

        val splits = c.filter { it.value < k }.map { it.key.toString() }.toTypedArray()
        return s.split(*splits).map { longestSubstring(it, k) }.max() ?: 0
    }
}

fun main() {
    println(Solution395().longestSubstring("ababbcddeeffgadhddefiffe", 2))
}