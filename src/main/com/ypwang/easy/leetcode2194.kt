package com.ypwang.easy

class Solution2194 {
    fun cellsInRange(s: String): List<String> {
        val a = s[0]
        val b = s[3]
        val c = s[1]
        val d = s[4]

        return (a..b).flatMap { a ->
            (c..d).map { b -> "$a$b" }
        }
    }
}