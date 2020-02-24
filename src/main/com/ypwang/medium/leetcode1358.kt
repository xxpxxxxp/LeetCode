package com.ypwang.medium

class Solution1358 {
    fun numberOfSubstrings(s: String): Int {
        val count = IntArray(3)
        var rst = 0
        var i = 0
        var j = 0

        while (j < s.length) {
            while (j < s.length && count.any { it == 0 }) {
                rst += i
                count[s[j] - 'a']++
                j++
            }

            while (i < s.length && count.all { it > 0 }) {
                count[s[i] - 'a']--
                i++
            }
        }

        rst += i

        return rst
    }
}

fun main() {
    println(Solution1358().numberOfSubstrings("acbbcac"))
    println(Solution1358().numberOfSubstrings("abcabc"))
    println(Solution1358().numberOfSubstrings("aaacb"))
    println(Solution1358().numberOfSubstrings("abc"))
}