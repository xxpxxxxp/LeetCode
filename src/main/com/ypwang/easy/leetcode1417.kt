package com.ypwang.easy

import java.lang.StringBuilder

class Solution1417 {
    fun reformat(s: String): String {
        val digits = s.filter { it.isDigit() }
        if (Math.abs(s.length - digits.length - digits.length) > 1) return ""

        val letters = s.filter { it.isLetter() }
        val digitEven = digits.length > letters.length

        val di = digits.iterator()
        val li = letters.iterator()

        val sb = StringBuilder()
        for (i in s.indices)
            sb.append(if (!digitEven.xor(i % 2 == 0)) di.nextChar() else li.nextChar())

        return sb.toString()
    }
}

fun main() {
    println(Solution1417().reformat("a0b1c2"))
}