package com.ypwang.medium

import java.util.*

class Solution402 {
    fun removeKdigits(num: String, k: Int): String {
        var count = k
        val stack = Stack<Char>()

        var i = 0
        while (count > 0 && i < num.length) {
            if (stack.isEmpty() || stack.peek() <= num[i]) stack.add(num[i])
            else {
                while (stack.isNotEmpty() && stack.peek() > num[i] && count > 0) {
                    stack.pop()
                    count--
                }
                stack.add(num[i])
            }
            i++
        }

        return (stack.joinToString("") + num.substring(i)).dropWhile { it == '0' }.dropLast(count).let { if (it.isEmpty()) "0" else it }
    }
}

fun main() {
    println(Solution402().removeKdigits("9", 1))
    println(Solution402().removeKdigits("1432219", 3))
    println(Solution402().removeKdigits("10200", 1))
    println(Solution402().removeKdigits("10", 2))
    println(Solution402().removeKdigits("1107", 1))
}