package com.ypwang.medium

class Solution1638 {
    fun countSubstrings(s: String, t: String): Int {
        var rst = 0
        for (i in s.indices) {
            for (j in t.indices) {
                var missed = 0
                for (k in 0 until minOf(s.length-i, t.length-j)) {
                    if (s[i+k] != t[j+k] && ++missed > 1)
                        break

                    rst += missed
                }
            }
        }

        return rst
    }
}

fun main() {
    println(Solution1638().countSubstrings("aba", "baba"))
    println(Solution1638().countSubstrings("ab", "bb"))
    println(Solution1638().countSubstrings("a", "a"))
    println(Solution1638().countSubstrings("abe", "bbc"))
}