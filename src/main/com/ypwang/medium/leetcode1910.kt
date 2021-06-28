package com.ypwang.medium

class Solution1910 {
    fun removeOccurrences(s: String, part: String): String {
        val idx = s.indexOf(part)
        if (idx == -1)
            return s

        return removeOccurrences(s.replaceRange(idx, idx + part.length, ""), part)
    }
}