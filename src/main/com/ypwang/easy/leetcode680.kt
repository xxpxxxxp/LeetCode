package com.ypwang.easy

class Solution680 {
    fun helper(s: String, maxSkip: Int): Boolean {
        var i = 0
        var j = s.lastIndex
        while (i < j) {
            if (s[i] != s[j]) {
                if (maxSkip <= 0) {
                    return false
                }

                return helper(s.substring(i + 1, j + 1), maxSkip - 1) || helper(s.substring(i, j), maxSkip - 1)
            }
            i++
            j--
        }
        return true
    }

    fun validPalindrome(s: String): Boolean {
        return helper(s, 1)
    }
}

fun main(args: Array<String>) {
    println(Solution680().validPalindrome("deeee"))
    println(Solution680().validPalindrome("abca"))
}