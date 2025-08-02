package com.ypwang.easy

class Solution3438 {
    fun findValidPair(s: String): String {
        val set = s.groupBy { it }.mapValues { it.value.size }.filter { it.key - '0' == it.value }.map { it.key }.toSet()
        for (i in 0 until s.lastIndex) {
            if (s[i] != s[i+1] && s[i] in set && s[i+1] in set)
                return s.substring(i, i+2)
        }

        return ""
    }
}
