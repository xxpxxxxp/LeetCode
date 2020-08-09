package com.ypwang.easy

import java.util.*

class Solution1544 {
    fun makeGood(s: String): String {
        val stack = Stack<Char>()

        for (c in s) {
            if (stack.isNotEmpty() && Math.abs(stack.peek() - c) == 32) stack.pop()
            else stack.add(c)
        }
        return stack.joinToString("")
    }
}

fun main() {
    println(Solution1544().makeGood("leEeetcode"))
}