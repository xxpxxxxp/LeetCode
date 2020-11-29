package com.ypwang.medium

import java.lang.StringBuilder

class Solution537 {
    fun helper(a: String): Pair<Int, Int> {
        val breakIndex = a.lastIndexOf('+')
        return Pair(a.substring(0, breakIndex).toInt(), a.substring(breakIndex+1, a.lastIndex).toInt())
    }

    fun complexNumberMultiply(a: String, b: String): String {
        val f = helper(a)
        val s = helper(b)
        return StringBuilder().apply {
            append(f.first * s.first - f.second * s.second)
            append('+')
            append(f.first * s.second + f.second * s.first)
            append('i')
        }.toString()
    }
}

fun main() {
    println(Solution537().complexNumberMultiply("1+-1i", "1+-1i"))
}