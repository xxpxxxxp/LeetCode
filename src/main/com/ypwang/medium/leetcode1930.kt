package com.ypwang.medium

class Solution1930 {
    fun countPalindromicSubsequence(s: String): Int =
        ('a'..'z').map {
            var c = 0
            val l = s.indexOf(it)
            if (l != -1) {
                val r = s.lastIndexOf(it)
                val exist = BooleanArray(26)
                for (i in l+1 until r)
                    exist[s[i] - 'a'] = true

                c = exist.count { b -> b }
            }

            c
        }.sum()
}

fun main() {
    println(Solution1930().countPalindromicSubsequence("tlpjzdmtwderpkpmgoyrcxttiheassztncqvnfjeyxxp"))
}