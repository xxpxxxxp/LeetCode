package com.ypwang.hard

class Solution214 {
    fun shortestPalindrome(s: String): String {
        var b = s.lastIndex

        while (true) {
            var i = 0
            var j = b

            var p = true
            while (i < j) {
                if (s[i] != s[j]) {
                    p = false
                    break
                }
                i++
                j--
            }

            if (p) break
            b--
        }

        return s.substring(b+1).reversed() + s
    }
}

fun main() {
    println(Solution214().shortestPalindrome("aacecaaa"))
    println(Solution214().shortestPalindrome("abcd"))
}