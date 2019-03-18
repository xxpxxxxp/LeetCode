package com.ypwang.medium

import java.util.*

class Solution150 {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Int>()

        for (token in tokens) {
            when (token) {
                "+" -> {
                    val right = stack.pop()
                    val left = stack.pop()
                    stack.push(left + right)
                }
                "-" -> {
                    val right = stack.pop()
                    val left = stack.pop()
                    stack.push(left - right)
                }
                "*" -> {
                    val right = stack.pop()
                    val left = stack.pop()
                    stack.push(left * right)
                }
                "/" -> {
                    val right = stack.pop()
                    val left = stack.pop()
                    stack.push(left / right)
                }
                else -> stack.push(token.toInt())
            }
        }

        return stack.pop()
    }
}

fun main(args: Array<String>) {
    println(Solution150().evalRPN(arrayOf("4", "13", "5", "/", "+")))
}