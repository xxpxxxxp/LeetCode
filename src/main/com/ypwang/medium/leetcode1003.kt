package com.ypwang.medium

import java.util.*

class Solution1003 {
    fun isValid(S: String): Boolean {
        val stack = Stack<Char>()

        for (c in S) {
            when (c) {
                'a' -> stack.push(c)
                'b' -> {
                    if (stack.isNotEmpty() && stack.peek() == 'a') {
                        stack.pop()
                        stack.push(c)
                    } else {
                        return false
                    }
                }
                'c' -> {
                    if (stack.isNotEmpty() && stack.peek() == 'b') {
                        stack.pop()
                    } else {
                        return false
                    }
                }
            }
        }

        return stack.isEmpty()
    }
}

fun main() {
    println(Solution1003().isValid("aabcbc"))
}