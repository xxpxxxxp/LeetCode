package com.ypwang.easy

class Solution647 {
    fun helper(s: String, i: Double): Int {
        var result = 0
        while (true) {
            val left = Math.floor(i - 0.5 - result).toInt()
            val right = Math.ceil(i + 0.5 + result).toInt()
            if (left >=0 && right < s.length && s[left] == s[right]) {
                result++
            } else {
                break
            }
        }
        return result + if (Math.ceil(i) == i) 1 else 0
    }

    fun countSubstrings(s: String): Int {
        return (0 until 2*s.length).map{ it/2.0 }.sumBy{ helper(s, it) }
    }
}

fun main(args: Array<String>) {
    println(Solution647().countSubstrings("aaa"))
}