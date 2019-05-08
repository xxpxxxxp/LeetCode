package com.ypwang.easy

import java.lang.StringBuilder

class Solution1021 {
    fun removeOuterParentheses(S: String): String {
        var stack = 0
        var start = 0
        var end = 0

        val rst = StringBuilder()
        S.forEach {
            when (it) {
                '(' -> stack++
                ')' -> stack--
                else -> {}
            }

            end++
            if (stack == 0) {
                rst.append(S.substring(start+1, end-1))
                start = end
            }
        }

        return rst.toString()
    }
}

fun main() {
    println(Solution1021().removeOuterParentheses("()()"))
}