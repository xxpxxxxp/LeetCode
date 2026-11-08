package com.ypwang.medium

class Solution4106 {
    fun findMismatchedSegments(s1: String, s2: String): List<List<String>> {
        val n = s1.length
        var i = 0
        val list = mutableListOf<List<String>>()

        while (i < n) {
            if (s1[i] == s2[i]) {
                i++
            } else {
                val start = i

                while (i < n && s1[i] != s2[i])
                    i++

                list.add(listOf(s1.substring(start, i), s2.substring(start, i)))
            }
        }

        return list
    }
}
