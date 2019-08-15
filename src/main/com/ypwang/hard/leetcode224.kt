package com.ypwang.hard

import java.util.*

class Solution224 {
    private fun readInt(iter: Queue<Char>): Int {
        var start = 0
        while (iter.isNotEmpty() && iter.peek().isDigit()) {
            start = start * 10 + (iter.poll() - '0')
        }
        return start
    }

    private fun eval(iter: Queue<Char>): Int {
        var rst = 0
        var sign = true     // positive
        label@while (iter.isNotEmpty()) {
            when (iter.peek()) {
                '(' -> {
                    iter.poll()     // pop (
                    rst += eval(iter).let { if (sign) it else -it }
                }
                ')' -> {
                    iter.poll()
                    break@label
                }
                '+' -> {
                    iter.poll()
                    sign = true
                }
                '-' -> {
                    iter.poll()
                    sign = false
                }
                ' ' -> iter.poll()
                else -> rst += readInt(iter).let { if (sign) it else -it }
            }
        }

        return rst
    }

    fun calculate(s: String): Int = eval(LinkedList(s.toList()))
}

fun main() {
    println(Solution224().calculate("1 + 1"))
    println(Solution224().calculate(" 2-1 + 2 "))
    println(Solution224().calculate("(1+(4+5+2)-3)+(6+8)"))
}