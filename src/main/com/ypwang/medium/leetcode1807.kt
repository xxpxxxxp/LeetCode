package com.ypwang.medium

class Solution1807 {
    fun evaluate(s: String, knowledge: List<List<String>>): String {
        val map = knowledge.map { (a, b) -> a to b }.toMap()

        val sb = StringBuilder()
        var i = 0
        while (i < s.length) {
            when (s[i]) {
                '(' -> {
                    i++
                    val end = s.indexOf(')', i)
                    sb.append(map.getOrDefault(s.substring(i, end), "?"))
                    i = end + 1
                }
                else -> sb.append(s[i++])
            }
        }

        return sb.toString()
    }
}