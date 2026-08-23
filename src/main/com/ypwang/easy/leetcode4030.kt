package com.ypwang.easy

class Solution4030 {
    fun isPalindromic(s: String): Boolean =
        (0..(s.length/2)).all {
            s[it].code.toString(2).padStart(8, '0').reversed() == s[s.length-1-it].code.toString(2).padStart(8, '0')
        }
}

fun main() {
    println(Solution4030().isPalindromic("ff"))
}