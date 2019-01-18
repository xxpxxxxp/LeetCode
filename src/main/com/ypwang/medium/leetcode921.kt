package com.ypwang.medium

class Solution921 {
    fun minAddToMakeValid(S: String): Int {
        var stack = 0
        var count = 0
        for (c in S) {
            when (c) {
                '(' -> {
                    stack++
                }
                ')' -> {
                    stack--
                    if (stack < 0) {
                        count += -stack
                        stack = 0
                    }
                }
                else -> {}
            }
        }
        count += stack
        return count
    }
}

fun main(args: Array<String>) {
    println(Solution921().minAddToMakeValid("())"))
    println(Solution921().minAddToMakeValid("((("))
    println(Solution921().minAddToMakeValid("()"))
    println(Solution921().minAddToMakeValid("()))(("))
}