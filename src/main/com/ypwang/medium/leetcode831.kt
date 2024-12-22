package com.ypwang.medium

import java.lang.StringBuilder

class Solution831 {
    fun maskEmail(S: String): String {
        val part = S.split('@')
        return StringBuilder().apply {
            append(part[0].first().lowercase())
            append("*****")
            append(part[0].last().lowercase())
            append('@')
            append(part[1].lowercase())
        }.toString()
    }

    fun maskPhone(S: String): String {
        val numbers = S.filter { it.isDigit() }

        return StringBuilder().apply {
            if (numbers.length > 10) {
                append('+')
                for (i in 0 until (numbers.length-10))
                    append('*')
                append('-')
            }
            append("***-***-")
            append(numbers.takeLast(4))
        }.toString()
    }

    fun maskPII(S: String): String {
        return if (S.contains('@')) maskEmail(S) else maskPhone(S)
    }
}

fun main() {
    println(Solution831().maskPII("LeetCode@LeetCode.com"))
    println(Solution831().maskPII("AB@qq.com"))
    println(Solution831().maskPII("1(234)567-890"))
    println(Solution831().maskPII("86-(10)12345678"))
}