package com.ypwang.medium

class Solution3805 {
    private fun unify(s: String): String {
        if (s.isEmpty())
            return ""
        val sb = StringBuilder()
        val c = s[0] - 'a'
        for (i in 0 until s.length) {
            val v = s[i] - 'a'
            val n = (v - c + 26) % 26
            sb.append('a' + n)
        }
        return sb.toString()
    }

    fun countPairs(words: Array<String>): Long =
        words.map { unify(it) }
            .groupBy { it }
            .map { it.value.size }
            .sumOf { it.toLong() * (it - 1) / 2 }
}
