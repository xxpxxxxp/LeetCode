package com.ypwang.easy

class Solution2446 {
    private fun convert(s: String): Int {
        val (p1, p2) = s.split(":")
        return p1.toInt() * 60 + p2.toInt()
    }

    fun haveConflict(event1: Array<String>, event2: Array<String>): Boolean {
        val (s1, e1) = event1
        val (s2, e2) = event2

        val s1i = convert(s1)
        val e1i = convert(e1)
        val s2i = convert(s2)
        val e2i = convert(e2)

        return s1i in s2i..e2i || e1i in s2i..e2i || s2i in s1i..e1i || e2i in s1i..e1i
    }
}