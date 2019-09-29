package com.ypwang.hard

import java.util.*

class Solution65 {
    private val ops = setOf('+', '-')

    private fun assetFloat(iter: Queue<Char>): Boolean {
        if (iter.isEmpty()) return false
        val intPart = assetInt(iter)
        return if (iter.isNotEmpty() && iter.peek() == '.') {
            iter.poll()
            val floatPart = assetInt(iter)
            intPart || floatPart
        } else return intPart
    }

    private fun assetInt(iter: Queue<Char>): Boolean {
        if (iter.isEmpty()) return false
        if (iter.peek() in ops) iter.poll()
        if (iter.isEmpty() || !iter.peek().isDigit()) return false
        while (!iter.isEmpty() && iter.peek().isDigit()) iter.poll()
        return true
    }

    fun isNumber(s: String): Boolean {
        val q = LinkedList(s.filter { it != ' ' }.toList())
        if (!assetFloat(q)) return false
        if (q.isEmpty()) return true
        if (q.poll() != 'e') return false
        if (!assetInt(q)) return false
        return q.isEmpty()
    }
}

fun main() {
    println(Solution65().isNumber("3."))
    println(Solution65().isNumber(".1"))
    println(Solution65().isNumber("0"))
    println(Solution65().isNumber(" 0.1 "))
    println(!Solution65().isNumber("abc"))
    println(!Solution65().isNumber("1 a"))
    println(Solution65().isNumber("2e10"))
    println(Solution65().isNumber(" -90e3   "))
    println(!Solution65().isNumber(" 1e"))
    println(!Solution65().isNumber("e3"))
    println(Solution65().isNumber(" 6e-1"))
    println(!Solution65().isNumber(" 99e2.5 "))
    println(Solution65().isNumber("53.5e93"))
    println(!Solution65().isNumber(" --6 "))
    println(!Solution65().isNumber("-+3"))
    println(!Solution65().isNumber("95a54e53"))
}