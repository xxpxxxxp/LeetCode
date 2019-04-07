package com.ypwang.medium

import java.util.*

class Solution640 {
    // Pair(k * x, c)
    private fun helper(expression: String): Pair<Int, Int> {
        val q: Queue<Char> = LinkedList(expression.toList())

        var x = 0
        var c = 0

        var sign = true
        while (true) {
            when (q.peek()) {
                null -> return Pair(x, c)
                '+' -> {
                    sign = true
                    q.poll()
                }
                '-' -> {
                    sign = false
                    q.poll()
                }
                'x' -> {
                    if (sign) x++ else x--
                    sign = true
                    q.poll()
                }
                else -> {
                    var t = 0
                    while (q.peek() != null && q.peek().isDigit()) {
                        t = t * 10 + (q.poll() - '0')
                    }

                    when {
                        q.peek() == 'x' -> {
                            if (sign) x += t else x -= t
                            q.poll()
                        }
                        sign -> c += t
                        else -> c -= t
                    }

                    sign = true
                }
            }
        }
    }

    fun solveEquation(equation: String): String {
        val t = equation.split('=')
        assert(t.size == 2)
        val left = helper(t[0])
        val right = helper(t[1])

        val x = left.first - right.first
        val c = right.second - left.second

        if (x == 0) {
            return if (c == 0) "Infinite solutions" else "No solution"
        }
        return "x=${c / x}"
    }
}

fun main() {
//    println(Solution640().solveEquation("x+5-3+x=6+x-2"))
//    println(Solution640().solveEquation("x=x"))
//    println(Solution640().solveEquation("2x=x"))
    println(Solution640().solveEquation("2x+3x-6x=x+2"))
//    println(Solution640().solveEquation("x=x+2"))
}