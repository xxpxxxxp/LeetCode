package com.ypwang.medium

import java.lang.Exception
import java.util.*

class Solution856 {
    fun helper(remain: Queue<Char>): Int {
        if (remain.isEmpty()) {
            return 0
        }

        if (remain.poll() != '(') {
            throw Exception("invalid")
        }

        var rst = 0

        while (remain.peek() == '(') {
            rst += helper(remain)
        }

        if (remain.poll() != ')') {
            throw Exception("invalid")
        }
        return if (rst == 0) 1 else 2 * rst
    }

    fun scoreOfParentheses(S: String): Int {
        return helper(LinkedList<Char>(("(" + S + ")").toList())) / 2
    }
}

fun main(args: Array<String>) {
    println(Solution856().scoreOfParentheses("(()(()))"))
}