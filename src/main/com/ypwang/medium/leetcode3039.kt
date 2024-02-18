package com.ypwang.medium

class Solution3039 {
    fun lastNonEmptyString(s: String): String {
        val lastIdx = IntArray(26)
        val count = IntArray(26)

        for ((i, c) in s.withIndex()) {
            val j = c - 'a'
            lastIdx[j] = i
            count[j]++
        }

        val max = count.max()
        return count
            .asSequence()
            .withIndex()
            .filter { it.value == max }
            .sortedBy { lastIdx[it.index] }
            .map { 'a' + it.index }
            .joinToString("")
    }
}