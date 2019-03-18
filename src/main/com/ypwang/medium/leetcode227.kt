package com.ypwang.medium

import java.util.*

class Solution227 {
    private fun readInt(q: Queue<Char>): Int {
        var negative = false
        if (q.peek() == '-') {
            negative = true
            q.poll()
        }

        var i = 0
        while (q.peek() != null && q.peek() in '0'..'9') {
            i *= 10
            i += q.poll() - '0'
        }

        if (negative) {
            i = -i
        }

        return i
    }

    private fun readOp(q: Queue<Char>): Char? {
        return q.poll()
    }

    private fun calculate(q: Queue<Char>): Int {
        var stack = Stack<Int>()
        stack.push(readInt(q))

        while (true) {
            val op = readOp(q) ?: break

            when (op) {
                '+' -> stack.push(readInt(q))
                '-' -> stack.push(-readInt(q))
                '*' -> stack.push(stack.pop() * readInt(q))
                '/' -> stack.push(stack.pop() / readInt(q))
            }
        }

        return stack.sum()
    }

    fun calculate(s: String): Int {
        val q: Queue<Char> = LinkedList(s.filter { it != ' ' }.toList())
        return calculate(q)
    }
}

fun main() {
    println(Solution227().calculate(" 3+5 / 2 "))
}