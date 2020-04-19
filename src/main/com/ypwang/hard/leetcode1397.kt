package com.ypwang.hard

class Solution1397 {
    private val mod = 1000000007
    private fun helper(pre: String, bigger: Boolean, smaller: Boolean, n: Int, s1: String, s2: String, evil: String): Int {
        if (pre.endsWith(evil)) return 0
        if (pre.length == n) return 1
        return ('a'..'z').map {
            if (!bigger && it < s1[pre.length]) 0
            else if (!smaller && it > s2[pre.length]) 0
            else helper(pre + it, bigger or (it > s1[pre.length]), smaller or (it < s2[pre.length]), n, s1, s2, evil)
        }.reduce { acc, i -> (acc + i) % mod }
    }

    fun findGoodStrings(n: Int, s1: String, s2: String, evil: String): Int =
        helper("", false, false, n, s1, s2, evil)
}

fun main() {
    println(Solution1397().findGoodStrings(2, "aa", "da", "b"))
    println(Solution1397().findGoodStrings(8, "leetcode", "leetgoes", "leet"))
    println(Solution1397().findGoodStrings(2, "gx", "gz", "x"))
}