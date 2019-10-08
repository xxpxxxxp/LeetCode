package com.ypwang.medium

import java.lang.StringBuilder
import java.util.*

class Solution1190 {
    interface i1190 {
        fun yield(): String
    }

    data class String1190(val str: String, val reverse: Boolean): i1190 {
        override fun yield(): String = if (reverse) str.reversed() else str
    }

    data class Composed(val inner: List<i1190>, val reverse: Boolean): i1190 {
        override fun yield(): String = inner.map { it.yield() }.let { if (reverse) it.reversed().joinToString("") else it.joinToString("") }
    }

    private fun parse(iter: Queue<Char>, reverse: Boolean): i1190 {
        assert(iter.poll() == '(')

        val rst = mutableListOf<i1190>()
        while (true) {
            when (iter.peek()) {
                '(' -> rst.add(parse(iter, !reverse))
                ')' -> {
                    iter.poll()
                    return if (rst.size == 1) rst.first() else Composed(rst, reverse)
                }
                else -> {
                    val sb = StringBuilder()
                    while (iter.peek().isLetter()) sb.append(iter.poll())
                    rst.add(String1190(sb.toString(), reverse))
                }
            }
        }
    }

    fun reverseParentheses(s: String): String {
        return parse(LinkedList("($s)".toList()), false).yield()
    }
}

fun main() {
    println(Solution1190().reverseParentheses( "(abcd)"))
    println(Solution1190().reverseParentheses( "(u(love)i)"))
    println(Solution1190().reverseParentheses( "(ed(et(oc))el)"))
    println(Solution1190().reverseParentheses( "a(bcdefghijkl(mno)p)q"))
}