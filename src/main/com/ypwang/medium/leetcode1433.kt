package com.ypwang.medium

class Solution1433 {
    fun checkIfCanBreak(s1: String, s2: String): Boolean {
        val c1 = IntArray(26)
        val c2 = IntArray(26)
        s1.forEach { c1[it - 'a']++ }
        s2.forEach { c2[it - 'a']++ }

        var x = 0
        var y = 0
        var p = true
        var q = true
        for (i in 0 until 26) {
            x += c2[i] - c1[i]
            y += c1[i] - c2[i]
            if (x < 0) p = false
            if (y < 0) q = false
        }
        return p || q
    }
}

fun main() {
    println(Solution1433().checkIfCanBreak("abc", "xya"))
    println(Solution1433().checkIfCanBreak("abe", "acd"))
    println(Solution1433().checkIfCanBreak("leetcodee", "interview"))
}