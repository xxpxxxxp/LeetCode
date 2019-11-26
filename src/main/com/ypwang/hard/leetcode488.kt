package com.ypwang.hard

import java.lang.StringBuilder
import java.util.*

class Solution488 {
    val max = 6
    fun findMinStep(board: String, hand: String): Int {
        val handCount = IntArray(26)
        for (c in hand) handCount[c - 'A']++
        val rs = helper("$board#", handCount)
        return if (rs == max) -1 else rs
    }

    private fun helper(s: String, h: IntArray): Int {
        val ss = removeConsecutive(s)
        if (ss == "#") return 0
        var rs = max
        var i = 0
        var j = 0
        while (j < ss.length) {
            if (ss[j] == ss[i]) j++
            else {
                val need = 3 + i - j
                if (h[ss[i] - 'A'] >= need) {
                    // back tracing
                    h[ss[i] - 'A'] -= need
                    rs = minOf(rs, need + helper(ss.substring(0, i) + ss.substring(j), h))
                    h[ss[i] - 'A'] += need
                }
                i = j++
            }
        }
        return rs
    }

    private fun removeConsecutive(board: String): String {
        data class MPair<T, U>(val first: T, var second: U)
        val stack = Stack<MPair<Char, Int>>()
        for (c in board) {
            if (stack.isEmpty()) stack.add(MPair(c, 1))
            else {
                if (stack.peek().first == c) stack.peek().second++
                else {
                    if (stack.peek().second > 2) stack.pop()
                    if (stack.isNotEmpty() && stack.peek().first == c) stack.peek().second++
                    else stack.add(MPair(c, 1))
                }
            }
        }

        return StringBuilder().apply {
            stack.forEach { (0 until it.second).forEach { _ -> this.append(it.first) } }
        }.toString()
    }
}

fun main() {
    println(Solution488().findMinStep("RRGGWYYWWGGR","YRG"))
    println(Solution488().findMinStep("WRRBBW", "RB"))
    println(Solution488().findMinStep("WWRRBBWW", "WRBRW"))
    println(Solution488().findMinStep("G", "GGGGG"))
    println(Solution488().findMinStep("RBYYBBRRB", "YRBGB"))
}