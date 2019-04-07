package com.ypwang.medium

import java.lang.StringBuilder
import java.util.*

class Solution394 {
    private fun helper(s: Queue<Char>): String {
        var t = 0
        while (s.peek().isDigit()) {
            t = t * 10 + (s.poll() - '0')
        }
        assert(t != 0)
        assert(s.poll() == '[')

        val include = StringBuilder()
        while (true) {
            val n = s.peek()
            when {
                n == null || n == ']' -> {
                    s.poll()
                    val q = include.toString()
                    return (0 until t).joinToString("") { q }
                }
                n.isDigit() ->include.append(helper(s))
                else -> {
                    s.poll()
                    include.append(n)
                }
            }
        }
    }

    fun decodeString(s: String): String {
        return helper(LinkedList<Char>("1[$s]".toList()))
    }
}

fun main() {
    println(Solution394().decodeString("2[abc]3[cd]ef"))
}