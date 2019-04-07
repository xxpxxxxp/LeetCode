package com.ypwang.medium

class Solution1023 {
    fun camelMatch(queries: Array<String>, pattern: String): BooleanArray {
        return queries.map {
            var i = 0

            for (c in it) {
                if (c.isUpperCase()) {
                    if (i == pattern.length || pattern[i] != c) return@map false
                    else i++
                } else {
                    if (i < pattern.length && pattern[i] == c) i++
                }
            }

            i == pattern.length
        }.toBooleanArray()
    }
}