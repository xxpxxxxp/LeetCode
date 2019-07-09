package com.ypwang.hard

class Solution87 {
    fun isScramble(s1: String, s2: String): Boolean {
        if (s1.length != s2.length) return false
        if (s1.isEmpty()) return true

        val s1p = IntArray(26)
        val s2pf = IntArray(26)
        val s2pb = IntArray(26)

        for (i in 0 until s1.length) {
            if (i == s1.lastIndex) return s1 == s2 || s1 == s2.reversed()

            s1p[s1[i] - 'a']++
            s2pf[s2[i] - 'a']++
            s2pb[s2[s1.lastIndex - i] - 'a']++

            if (s1p.contentEquals(s2pf) && isScramble(s1.substring(0, i+1), s2.substring(0, i+1)) && isScramble(s1.substring(i+1), s2.substring(i+1)))
                return true

            if (s1p.contentEquals(s2pb) && isScramble(s1.substring(0, i+1), s2.substring(s1.lastIndex-i)) && isScramble(s1.substring(i+1), s2.substring(0, s1.lastIndex-i)))
                return true
        }

        return false
    }
}

fun main() {
    println(Solution87().isScramble("abc", "bca"))
}