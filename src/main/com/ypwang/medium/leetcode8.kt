package com.ypwang.medium

class Solution8 {
    fun myAtoi(str: String): Int {
        if (str.isEmpty()) return 0

        var i = 0
        while (i < str.length && str[i] == ' ')
            i++

        var negative = false
        if (i < str.length) {
            when (str[i]) {
                '-' -> {
                    i++
                    negative = true
                }
                '+' -> i++
                else -> {}
            }
        }

        if (i == str.length || !str[i].isDigit()) return 0
        var num = if (negative) -(str[i] - '0') else (str[i] - '0')
        i++

        while (i < str.length && str[i].isDigit()) {
            val t = num
            num = num * 10 + if (negative) -(str[i] - '0') else (str[i] - '0')
            if (t != num / 10) {
                // overflow
                return if (negative) -2147483648 else 2147483647
            }
            i++
        }

        return num
    }
}

fun main() {
    println(Solution8().myAtoi("42"))
    println(Solution8().myAtoi("   -42"))
    println(Solution8().myAtoi("4193 with words"))
    println(Solution8().myAtoi("words and 987"))
    println(Solution8().myAtoi("-91283472332"))
}