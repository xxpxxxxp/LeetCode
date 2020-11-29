package com.ypwang.easy

class Solution696 {
    fun countBinarySubstrings(s: String): Int {
        return (0 until s.lastIndex).filter { s[it] != s[it + 1] }.map(fun(index): Int {
            var i = 1
            // s[index] != s[index+1]
            while ((index - i) >= 0 && s[index] == s[index - i] && (index + 1 + i) < s.length && s[index + 1] == s[index + 1 + i]) {
                i++
            }
            return i
        }).sum()
    }
}

fun main() {
    println(Solution696().countBinarySubstrings("10101"))
}