package com.ypwang.medium

import java.util.*

class Solution1717 {
    private fun count(s: String, dominate: String): Pair<String, Int> {
        var count = 0
        val stack: Stack<Char> = Stack()

        for (c in s) {
            if (stack.isNotEmpty() && "${stack.peek()}${c}" == dominate) {
                stack.pop()
                count++
            } else {
                stack.push(c)
            }
        }

        return stack.joinToString("") to count
    }

    fun maximumGain(s: String, x: Int, y: Int): Int {
        return if (x > y) {
            val (b, c1) = count(s, "ab")
            c1 * x + (count(b, "ba")).second * y
        } else {
            val (b, c1) = count(s, "ba")
            c1 * y + (count(b, "ab")).second * x
        }
    }
}

fun main() {
    println(Solution1717().maximumGain("cdbcbbaaabab", 4, 5))
}