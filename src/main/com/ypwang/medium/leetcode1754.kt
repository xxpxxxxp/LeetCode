package com.ypwang.medium

class Solution1754 {
    fun largestMerge(word1: String, word2: String): String {
        val sb = StringBuilder()
        var s1 = word1
        var s2 = word2

        while (s1.isNotEmpty() && s2.isNotEmpty()) {
            if (s1 > s2) {
                sb.append(s1[0])
                s1 = s1.substring(1)
            } else {
                sb.append(s2[0])
                s2 = s2.substring(1)
            }
        }

        sb.append(s1)
        sb.append(s2)

        return sb.toString()
    }
}